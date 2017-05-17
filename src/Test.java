import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Test{

   public static void main(String[]args){
      try{
      SocketServer server= new SocketServer();
      SocketClient client = new SocketClient();
      }
      catch(IOexception e){
         System.out.print(e);
      }
      server.run();
      client.run();
   }



}
