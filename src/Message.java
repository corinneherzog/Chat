import java.sql.Timestamp;

public class Message {
    //fields
    String receiver;
    String sender;
    Timestamp timeStamp;
    String text;
    //constructs the reciver and the message
    public Message( String receiver , String text){
        this.receiver = receiver;
        this.text = text;
    }
    //constructs the sender, the reciver, and the message
    public Message( String sender , String receiver , String text){
        this.receiver = receiver;
        this.sender = sender;
        this.text = text;
    }
    //constructs a message object
    public Message(){

    }
    //prints all the information in string form
    public String toString(){
        return("Sender: " + receiver + ", Receiver: " + sender + ", Time Stamp: " + timeStamp.toString() + ", Text: " + text);
    }
}
