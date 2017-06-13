import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by corinne on 6/11/17.
 */
public class ClientUI {
      JFrame frame;
      JPanel panel1;
      JTextPane textPane;
      String userName;
      String reciever;

      public static void main(String[] args){
         ClientUI ui = new ClientUI("Corinne");
      }

      public ClientUI(String UserName){
         frame = new JFrame();
         panel1 = new JPanel();
         this.userName = UserName;
         UI();
      }
      public void UI(){
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         frame.setSize(new Dimension(250, 300));
         frame.add(panel1);
         JTextField userEnter = new JTextField();
         frame.add(userEnter);
         userEnter.addActionListener(new ActionListener(){
            public void actionPerformed(){
               userName = userEnter.getText();
               userEnter.setEditable(false);
            }
         });

         textPane = new JTextPane();
         textPane.setSize(500,500);
         textPane.setEditable(false);
        // textPane.setBounds()
         frame.add(textPane);
         frame.setVisible(true);
      }

      public void addTextBoxes(ArrayList<Message> list){
         for(int i = 0 ; i < list.size() ; i++){
            Message message = list.get(i);
            JTextField textBox = new JTextField();
            textPane.add(textBox);
            textBox.setText(message.text);
            if(message.sender.equals(userName)){
               //set alignment left
            }
            else{
               //set alignment right
            }
            textBox.setVisible(true);
         }

      }
   }