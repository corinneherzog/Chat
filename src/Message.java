import java.sql.Timestamp;

/**
 * Created by corinne on 5/28/17.
 */
public class Message {
    String to;
    String from;
    Timestamp timeStamp;
    String message;

    public Message(String sender, String reciever , Timestamp timeStamp , String message){
        this.sender = sender;
        this.reciever = reciever;
        this.timeStamp = timeStamp;
        this.text = text;
    }

    public String toString(){
        return("Sender:" + to + "Reciever:" + from + " Time Stamp:" + timeStamp.toString() + "Text:" + message );
    }
}
