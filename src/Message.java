import java.sql.Timestamp;

public class Message {
    //fields
    String receiver;
    String sender;
    Timestamp timeStamp;
    String text;

    //Creates a new message given text and receiver
    public Message( String receiver , String text){
        this.receiver = receiver;
        this.text = text;
    }
    //Creates a new message with sender, receiver, and text
    public Message( String sender , String receiver , String text){
        this.receiver = receiver;
        this.sender = sender;
        this.text = text;
    }
    //prints all the information in string form
    public String toString(){
        return("Sender: " + receiver + ", Receiver: " + sender + ", Time Stamp: " + timeStamp.toString() + ", Text: " + text);
    }
}
