/**
 * Created by corinne on 5/24/17.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class ServerCorinne {

    static byte [] message = new byte[2000];

    public static void main(String[] args) throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/testServer" , new Handler());
        server.setExecutor(null);
        server.start();
    }

    static class Handler implements HttpHandler {
        public void handle(HttpExchange hte) throws IOException{
        InputStream is = hte.getRequestBody();
        byte [] binput = new byte[1000];
        int size = is.read(binput,0,binput.length);

        byte [] bresponse;
        //String txtResponse = "hi there"+binput.toString();

        //bresponse = txtResponse.getBytes();
        String cmd = hte.getRequestMethod();
        if (cmd.equals("POST")) {
            message = binput;
            bresponse = "".getBytes();
        } else {
            bresponse = message;
        }
        hte.sendResponseHeaders(200,bresponse.length);
        OutputStream os = hte.getResponseBody();
        os.write(bresponse);
        os.close();
        }
    }
    //HashMap<String, ArrayList<String>> hm = new HashMap<>();
}
