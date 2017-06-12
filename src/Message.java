import java.sql.Timestamp;

public class Message {
    String receiver;
    String sender;
    Timestamp timeStamp;
    String text;

    public Message( String receiver , String message){
        this.receiver = receiver;
        this.text = message;
    }

    public Message(){

    }

    public String toString(){
        return("Sender: " + receiver + ", Receiver: " + sender + ", Time Stamp: " + timeStamp.toString() + ", Text: " + text);
    }
}