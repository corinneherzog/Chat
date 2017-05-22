

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 * Created by corinne on 5/17/17.
 */
public class ClientTest {
    public static void main(String[] args){
        ArrayList<String> messagesSent = new ArrayList<>();
        ArrayList<String> messagesRecieved = new ArrayList<>();
        int portNum = Integer.parseInt(args[0]);

        try {
            Socket socket = new Socket("localhost",portNum) ;
            PrintWriter out =  new PrintWriter(socket.getOutputStream() , true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner userIn = new Scanner(System.in);
            String fromServer;
            String fromUser;

            while(true){
                fromUser = userIn.nextLine();
                out.println(fromUser);
                messagesSent.add(fromUser);
                fromServer = in.readLine();
                messagesRecieved.add(fromServer);
                System.out.println(fromServer);
                if(fromUser.equals("done")){
                    break;
                }
            }
            socket.close();
        }


        catch(IOException e){
            System.out.println("Couldn't establish i/o" + e);
        }
    }
}

