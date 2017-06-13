import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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

      public ClientUI(){
         frame = new JFrame();
         panel1 = new JPanel();
         UI();
      }
      public void UI(){
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         frame.setSize(new Dimension(250, 300));
         frame.add(panel1);
         JTextField userTextBox = new JTextField(10);
         frame.add(new JLabel("UserName: "));
         frame.add(userTextBox);
         textPane = new JTextPane();
         textPane.setSize(500,500);
         textPane.setEditable(false);
         frame.setVisible(true);
        // textPane.setBounds()
         userTextBox.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  userName= userTextBox.getText();
                  frame.remove(userTextBox);
                  frame.add(new JLabel(userName));
                  frame.setVisible(true);
                  textBoxMaker();
              }
          });
      }
      public void textBoxMaker(){
         frame.add(textPane);
         frame.setVisible(true);
      }
      public void addTextBoxes(ArrayList<Message> list){
          Container content = frame.getContentPane();
          content.setLayout(new GridLayout(0, 1));
         for(int i = 0 ; i < list.size() ; i++){
            Message message = list.get(i);
            JTextField textBox = new JTextField();
            textPane.add(textBox);
            textBox.setText(message.text);
            if(message.sender.equals(userName)){
                textBox.setHorizontalAlignment(JTextField.LEFT);
            }
            else{
                textBox.setHorizontalAlignment(JTextField.RIGHT);
            }
            textBox.setVisible(true);
         }

      }
   }
