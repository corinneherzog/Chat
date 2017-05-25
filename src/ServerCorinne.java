/**
 * Created by corinne on 5/24/17.
 */
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Scanner;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {
    public static void main(String[] args) throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/testServer" , new Handler());
        server.setExecutor(null);
        server.start();
    }


    static class Handler implements HttpHandler {
        public void handle(HttpExchange hte) throws IOException{
        Scanner console = new Scanner(System.in);
        String response = console.next();
        hte.sendResponseHeaders(200,response.getBytes().length);
        OutputStream os = hte.getResponseBody();
        os.write(response.getBytes());
        os.close();
        }

    }
}
