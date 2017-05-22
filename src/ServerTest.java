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

            String clientInput;
            String userInput;

            while(in.readLine()!= null || userIn.nextLine() != null){
                userInput = userIn.nextLine();
                out.println(userInput);
                messagesSent.add(userInput);
                clientInput = in.readLine();
                System.out.println(clientInput);
                messagesRecieved.add(clientInput);
            }
            socket.close();
        }

        catch(IOException e){
            System.out.print(e);
        }
    }
}
