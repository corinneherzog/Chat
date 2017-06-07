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
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import com.sun.net.httpserver.Headers;

public class Server {
    static HashMap<String, ArrayList<Message>> hm = new HashMap<>();


    public static void main(String[] args) throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/messages" , new Handler());
        server.setExecutor(null);
        server.start();
    }

    static class Handler implements HttpHandler {
        public void handle(HttpExchange hte) throws IOException{
        Gson gson = new Gson();
        BufferedReader in = new BufferedReader(new InputStreamReader(hte.getRequestBody()));
        String response = "";

        String cmd = hte.getRequestMethod();
        Headers headers = hte.getRequestHeaders();
        String user = headers.getFirst("user");
        if (cmd.equals("POST")) {
            storeData(in, gson ,user);
            response = "";
        }
        else if(cmd.equals("GET")){
            ArrayList<Message> list = hm.get(user);
            response = gson.toJson(list);

        }
        hte.sendResponseHeaders(200, response.getBytes().length);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(hte.getResponseBody()));

        out.write(response);
        out.close();
        }

        public void storeData(BufferedReader in,Gson gson, String user) throws IOException{
            String json = in.readLine();
            Message message = gson.fromJson(json, Message.class);
            message.timeStamp = new Timestamp(System.currentTimeMillis());
            message.from = user;
            String receiver = message.to;
            if((!(hm.containsKey(receiver)))) {
                ArrayList<Message> list = new ArrayList<>();
                hm.put(receiver, list);
            }
            hm.get(receiver).add(message);
        }
    }
}
