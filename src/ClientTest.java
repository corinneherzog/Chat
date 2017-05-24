import javax.swing.*;
import java.awt.*;

public class UserInterface {
   private JFrame frame;
   private JButton sendButton;
   private JButton doneButton;
   public UserInterface(){
       this.frame = new JFrame();
       this.sendButton = new JButton();
       this.doneButton = new JButton();
   }
   public void creatingChatFrame(){
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new FlowLayout());
      frame.setSize(new Dimension(300,175));
      frame.setTitle("Chat Box");
      JTextArea area = new JTextArea(5,20);
      frame.add(area);
      frame.add(new JScrollPane(area));
      creatingChatButtons();
      frame.setVisible(true);
   }
   
   private void creatingChatButtons(){
      sendButton.setText("send");
      sendButton.setBackground(Color.WHITE);
      doneButton.setText("done");
      doneButton.setBackground(Color.WHITE);
      frame.add(sendButton);
      frame.add(doneButton);
   
   } 
   
   public String sentMessageAdder(probablysomethingaboutthemessage){
      return probably the message;
   }
   public void endProgram(probablysomethingaboutthemessage){
      System.exit(0);
   }
}
