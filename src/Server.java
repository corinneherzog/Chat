/**
 * Created by corinne on 5/24/17.
 */
//import methodes that make it work
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
    //fields
    static HashMap<String, ArrayList<Message>> hm = new HashMap<>();
    static Timestamp prevTimeStamp = new Timestamp(System.currentTimeMillis());

    public static void main(String[] args) throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/messages" , new Handler());
        server.setExecutor(null);
        server.start();
    }
    
    //handels the post and get messages and sends that to user
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
            ArrayList<Message> listOut = new ArrayList<>();
            for(int i = 0 ; i < list.size() ; i++){
                if(list.get(i).timeStamp.after(prevTimeStamp)){
                    listOut.add(list.get(i));
                }
            }
            prevTimeStamp.setTime(System.currentTimeMillis());
            response = gson.toJson(listOut);
        }
        hte.sendResponseHeaders(200, response.getBytes().length);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(hte.getResponseBody()));

        out.write(response);
        out.close();
        }
        
        //stores the data of the message  and puts it into a hashmap
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
