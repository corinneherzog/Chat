package com.company;

import java.io.*;
import java.util.*;
import java.net.*;

/**
 * Created by corinne on 5/16/17.
 */
public class ServerTest {
    public static void main(String[] args){
        ArrayList<String>  messagesSent= new ArrayList<>();
        ArrayList<String>  messagesRecieved= new ArrayList<>();
        int portNum = Integer.parseInt(args[0]);

        try {
            ServerSocket serverSocket = new ServerSocket(portNum);
            Socket socket = serverSocket.accept();
            PrintWriter out =  new PrintWriter(socket.getOutputStream() , true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner userIn = new Scanner(System.in);

            System.out.println("Please enter your username");
            String userName = userIn.next();
            String fromUser;
            String fromClient;

            while(true){
                userInput = userIn.nextLine();
                out.println(userName + ": " + fromUser);
                messagesSent.add(fromUser);
                fromClient = in.readLine();
                System.out.println(fromClient);
                messagesRecieved.add(fromClient);
                if(fromUser.equals("done")){
                    break;
                }
            }
            socket.close();
        }
        catch(IOException e){
            System.out.print(e);
        }
    }
}

