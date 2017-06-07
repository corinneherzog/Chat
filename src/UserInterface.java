import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class UserInterface {
   JFrame frame;
   JButton sendButton;
   JButton doneButton;
   JTextArea area;
   public static void main(String[] args){

   }
   public void creatingChatFrame(){
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new FlowLayout());
      frame.setSize(new Dimension(300,175));
      frame.setTitle("Chat Box");
      this.area = new JTextArea(5,20);
      frame.add(area);
      frame.add(new JScrollPane(area));
      creatingChatButtons();
      frame.setVisible(true);
   }
   
   public void creatingChatButtons(){
      sendButton.setText("send");
      sendButton.setBackground(Color.WHITE);
      doneButton.setText("done");
      doneButton.setBackground(Color.WHITE);
      frame.add(sendButton);
      frame.add(doneButton);
   
   } 

}
