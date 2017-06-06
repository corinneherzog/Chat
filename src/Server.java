/**
 * Created by corinne on 5/24/17.
 */
/**
 * Created by corinne on 5/24/17.
 */
import java.io.*;
import java.net.InetSocketAddress;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;


import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {
    static HashMap<String, ArrayList<Message>> hm = new HashMap<>();
    static String messageOut;

    public static void main(String[] args) throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/testServer" , new Handler());
        server.setExecutor(null);
        server.start();
    }

    static class Handler implements HttpHandler {
        public void handle(HttpExchange hte) throws IOException{
        final Gson gson = new Gson();
        BufferedReader in = new BufferedReader(new InputStreamReader(hte.getRequestBody()));
        String response;

        String cmd = hte.getRequestMethod();
        if (cmd.equals("POST")) {
            Message currentMessage = storeData(in, gson);
            messageOut = gson.toJson(currentMessage);
            response = "";
        }
        else {
            response = messageOut;
        }
        hte.sendResponseHeaders(200, response.getBytes().length);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(hte.getResponseBody()));

        out.write(response);
        out.close();
        }

        public Message storeData(BufferedReader in,Gson gson) throws IOException{
            Message message = gson.fromJson(in, Message.class); //this is where the error is
            message.timeStamp = new Timestamp(System.currentTimeMillis());
            String receiver = message.to;
            if((!(hm.containsKey(receiver)))) {
                ArrayList<Message> list = new ArrayList<>();
                hm.put(receiver, list);
            }
            hm.get(receiver).add(message);
            return message;
        }
    }
}

