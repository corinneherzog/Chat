import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;

/**
 * Created by ros_crherzog on 5/16/2017.
 */
public class ServerTest {
    public static void main(String[] args){
        int portNumber = 4650;
        try{
            ServerSocket myClient = new ServerSocket(portNumber);
        }
        catch(IOException e){
            System.out.print(e);
        }


    }
}
