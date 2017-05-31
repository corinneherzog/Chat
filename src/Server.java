/**
 * Created by corinne on 5/24/17.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;


import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import javax.xml.bind.DatatypeConverter;

public class Server {
    static HashMap<String, ArrayList<Message>> hm = new HashMap<>();

    static byte [] messageOut = new byte[2000];

    public static void main(String[] args) throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/testServer" , new Handler());
        server.setExecutor(null);
        server.start();
    }

    static class Handler implements HttpHandler {
        public void handle(HttpExchange hte) throws IOException{
        final Gson gson = new Gson();
        InputStream is = hte.getRequestBody();
        byte [] binput = new byte[1000];
        int size = is.read(binput,0,binput.length);

        byte [] bresponse;

        String cmd = hte.getRequestMethod();
        if (cmd.equals("POST")) {
            Message currentMessage = storeData(binput , gson);
            messageOut = gson.toJson(currentMessage).getBytes();
            bresponse = "".getBytes();

        } else {
            bresponse = messageOut;
        }
        hte.sendResponseHeaders(200,bresponse.length);
        OutputStream os = hte.getResponseBody();
        os.write(bresponse);
        os.close();
        }

        public Message storeData(byte[] binput , Gson gson){
            String jSon = new String(binput);
            System.out.println(jSon); // for testing
            Message message = gson.fromJson(jSon, Message.class);
            message.timeStamp = new Timestamp(System.currentTimeMillis());
            String reciever = message.reciever;
            System.out.println(message); //for testing
            if((!(hm.containsKey(reciever)))){
                ArrayList<Message> list = new ArrayList<>();
                hm.put(reciever, list);
            }
            hm.get(reciever).add(message);
            return message;
        }
    }
}

