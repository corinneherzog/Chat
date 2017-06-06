import java.sql.Timestamp;

/**
 * Created by corinne on 5/28/17.
 */
public class Message {
    String to;
    String from;
    Timestamp timeStamp;
    String message;

    public Message(String to, String from , Timestamp timeStamp , String message){
        this.to = to;
        this.from = from;
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public String toString(){
        return("Sender:" + to + "Reciever:" + from + " Time Stamp:" + timeStamp.toString() + "Text:" + message );
    }
}
