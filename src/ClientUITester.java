import java.util.ArrayList;
public class ClientUITester {
   //testing if the client ui works
   public static void main(String[] args){
      MessageViewerUI  hi = new MessageViewerUI (new Client("http://localhost:8000/messages"));
      Message message1 = new Message("Corinne", "Hi");
      message1.sender = "Simone";
      Message message2 = new Message("Corinne" , "hello");
      message2.sender = "Simone";
      ArrayList<Message> arrayMessage = new ArrayList<Message>();
      arrayMessage.add(message1);
      arrayMessage.add(message2);
      hi.addTextBoxes(arrayMessage);


   }
}
