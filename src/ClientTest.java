import java.net.Socket;
import java.util.ArrayList;
import java.io.*;

public class ClientTest {
    public static void main(String[] args) throws IOException {
        ArrayList<String> messagesSent = new ArrayList<>();
        ArrayList<String> messagesRecieved = new ArrayList<>();
        int portNum = Integer.parseInt(args[0]);

        Socket client = new Socket("localhost",portNum) ;
        PrintWriter out =  new PrintWriter(client.getOutputStream() , true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;
        while((fromServer = in.readLine()) != null){
            if((fromUser = userIn.readLine()) != null ){
                messagesSent.add(fromUser);
                out.println(fromUser);
                System.out.print("User:" + fromUser);
            }
            System.out.print("Server:" + fromServer);
            messagesRecieved.add(fromServer);
            if(fromServer.equals("done")){
                break;
            }
        }
    }
}
