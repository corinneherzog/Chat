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
import com.sun.net.httpserver.Headers;

public class Server {
    static HashMap<String, ArrayList<Message>> hm = new HashMap<>();

    // Creates new http server to a given url and calls handler every time a request is received
    public static void main(String[] args) throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/messages" , new Handler());
        server.setExecutor(null);
        server.start();
    }
    
    //Handles post and get requests
    static class Handler implements HttpHandler {
        public void handle(HttpExchange hte) throws IOException{
        Gson gson = new Gson();
        BufferedReader in = new BufferedReader(new InputStreamReader(hte.getRequestBody()));
        String response = "";

        String cmd = hte.getRequestMethod();
        Headers requestHeaders = hte.getRequestHeaders();
        String user = requestHeaders.getFirst("user");
        if (cmd.equals("POST")) {
            storeData(in, gson ,user);
            response = "";
        }
        else if(cmd.equals("GET")){
            ArrayList<Message> list = hm.get(user);
            response = gson.toJson(list);
        }
        Headers responseHeaders = hte.getResponseHeaders();
        responseHeaders.add("Access-Control-Allow-Headers","x-prototype-version,x-requested-with" );
        responseHeaders.add("Access-Control-Allow-Headers","user" );
        responseHeaders.add("Access-Control-Allow-Methods","GET,POST");
        responseHeaders.add("Access-Control-Allow-Origin","*");

        hte.sendResponseHeaders(200, response.getBytes().length);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(hte.getResponseBody()));

        out.write(response);
        out.close();
        }
        
        //Reads in data, converts it into a message object from jSon and stores it in a hashmap
        //Each user(key) has an arraylist of all of the messages they've both sent and receiver.
        public void storeData(BufferedReader in,Gson gson, String user) throws IOException{
            String json = in.readLine();
            Message message = gson.fromJson(json, Message.class);
            message.timeStamp = new Timestamp(System.currentTimeMillis());
            message.sender = user;
            String receiver = message.receiver;
            if((!(hm.containsKey(receiver)))) {
                ArrayList<Message> list = new ArrayList<>();
                hm.put(receiver, list);
            }
            if(!(hm.containsKey(user))){
                ArrayList<Message> list = new ArrayList<>();
                hm.put(user, list);
            }
            hm.get(receiver).add(message);
            hm.get(user).add(message);
        }
    }
}
