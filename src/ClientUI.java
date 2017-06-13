import javax.swing.*;
import java.awt.*;

/**
 * Created by corinne on 6/11/17.
 */
public class ClientUI {
   JFrame frame;
   JPanel panel1;
   JList list1;
   JList list2;
   String UserName;

   public ClientUI(String UserName){
      frame = new JFrame();
      panel1 = new JPanel();
      this.UserName = UserName;
      UI();
   }
   public void UI(){
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new FlowLayout());
      frame.setSize(new Dimension(250, 300));
      frame.add(panel1);
      frame.add(new JLabel("UserName: " + UserName));
      JTextArea textBox = new JTextArea(10, 10);
      textBox.setBounds(20, 20, 10,20);
      frame.add (textBox);
      JTextArea textBox2 = new JTextArea(10, 10);
      textBox2.setBounds(10, 20, 50, 30);
      frame.add (textBox2);
      frame.add(new JScrollPane(textBox));
      frame.add(new JScrollPane(textBox2));
      frame.setVisible(true);

   }
}
