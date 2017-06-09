import java.sql.Timestamp;

/**
 * Created by corinne on 5/28/17.
 */
public class Message {
    String receiver;
    String sender;
    Timestamp timeStamp;
    String message;

    public Message(String goingTo, String fromWho , Timestamp timeStamp , String message){
        this.receiver = goingTo;
        this.sender = fromWho;
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public String toString(){
        return("Sender: " + receiver + ", Receiver: " + sender + ", Time Stamp: " + timeStamp.toString() + ", Message: " + message );
    }
}
