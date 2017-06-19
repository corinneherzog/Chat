import javax.swing.*;
import javax.swing.border.Border;
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

      public MessageViewerUI(Client client) {
          this.client = client;
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(new Dimension(250, 300));

          panel1.setLayout(new BoxLayout(panel1 , BoxLayout.PAGE_AXIS));
          JTextField userTextBox = new JTextField(10);
         frame.add(userTextBox);
          frame.add(refresh);
          refresh.setText("refresh");
          frame.setVisible(true);


          refresh.addActionListener(e -> {
              ArrayList<Message> list = client.getRequest(userName);
              addTextBoxes(list);

          });

          userTextBox.addActionListener(e -> {
              userName = userTextBox.getText();
              frame.remove(userTextBox);
              frame.add(new JLabel(userName));
              frame.setVisible(true);


          });

      }

      public void addTextBoxes(ArrayList<Message> list){
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
            textBox.setCaretColor(Color.BLUE);
            textBox.setEditable(false);
            frame.add(textBox);
            frame.setVisible(true);
         }
      }
   }
