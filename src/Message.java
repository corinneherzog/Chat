import java.sql.Timestamp;

/**
 * Created by corinne on 5/28/17.
 */
public class Message {
    String sender;
    String reciever;
    Timestamp timeStamp;
    String text;

    public Message(String sender, String reciever , Timestamp timeStamp , String text){
        this.sender = sender;
        this.reciever = reciever;
        this.timeStamp = timeStamp;
        this.text = text;
    }

    public String toString(){
        return("Sender:" + sender + "Reciever:" + reciever + " Time Stamp:" + timeStamp.toString() + "Text:" + text );
    }
}
