import java.sql.Timestamp;

/**
 * Created by corinne on 5/28/17.
 */
public class Message {
    String goingTo;
    String fromWho;
    Timestamp timeStamp;
    String message;

    public Message(String goingTo, String fromWho , Timestamp timeStamp , String message){
        this.goingTo = goingTo;
        this.fromWho = fromWho;
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public String toString(){
        return("Sender: " + fromWho + ", Reciever: " + goingTo + ", Time Stamp: " + timeStamp.toString() + ", Message: " + message );
    }
}
