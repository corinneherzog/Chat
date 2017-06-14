import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by corinne on 6/11/17.
 */
public class MessageViewerUI {

      final JFrame frame = new JFrame();
      final JPanel panel1 = new JPanel();
      final JTextPane textPane = new JTextPane();
      final JButton refresh = new JButton();
      String userName = "Corinne";
      Client client;

      public static void main(String[] args){
          String url;
          if(args.length > 0){
               url = args[0];
          }
          else{
              url ="http://localhost:8000/messages";
          }
          MessageViewerUI ui = new MessageViewerUI(new Client(url));
      }

      public MessageViewerUI(Client client){
         this.client = client;
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         frame.setSize(new Dimension(250, 300));
         frame.add(panel1);
         JTextField userTextBox = new JTextField(8);
         frame.add(userTextBox);
         textPane.setSize(500,500);
         textPane.setEditable(false);
         frame.add(refresh);
         frame.setVisible(true);


        // textPane.setBounds()
          refresh.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e){
                  ArrayList<Message> list = client.getRequest(userName);
                  addTextBoxes(list);
              }
          });

         userTextBox.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                  userName= userTextBox.getText();
                  frame.remove(userTextBox);
                  frame.add(new JLabel(userName));
                  frame.setVisible(true);


          });




      public void addTextBoxes(ArrayList<Message> list){
          Container content = frame.getContentPane();
          content.setLayout(new GridLayout(10, 10));
         for(int i = 0 ; i < list.size() ; i++){
            Message message = list.get(i);
            String text = message.text;
            JTextField textBox = new JTextField(text);
            if(message.sender.equals(userName)){
                textBox.setHorizontalAlignment(JTextField.RIGHT);
            }
            else{
                textBox.setHorizontalAlignment(JTextField.LEFT);
            }
            content.add(textBox);
            frame.setVisible(true);
         }
      }
   }