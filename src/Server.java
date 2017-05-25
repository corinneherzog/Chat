import com.sun.net.httpserver.HttpServer;
//use for later
//import com.sun.net.httpserver.HttpExchange;
//import com.sun.net.httpserver.HttpHandler;
import java.net.InetSocketAddress;

public class Server{

  public static void main(String [] args)throws Exception{
    HttpServer testServer = HttpServer.create(new InetSocketAddress(8000), 5);
    testServer.createContext("/hablabamos");
    //need to create a handler to deal with requests
    testServer.start();
  }
}
