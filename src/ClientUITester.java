import java.util.ArrayList;
public class ClientUITester {
   public static void main(String[] args){
      MessageViewerUI  hi = new MessageViewerUI (new Client("http://localhost:8000/messages"));
      Message message1 = new Message("Corinne", "Hi");
      message1.sender = "Simone";
      Message message2 = new Message("Simone", "No");
      message2.sender = "Corinne";
      ArrayList<Message> arrayMessage = new ArrayList<Message>();
      arrayMessage.add(message1);
      arrayMessage.add(message2);
      hi.addTextBoxes(arrayMessage);


   }
}
