
import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

/**
 * Created by simone on 6/8/17.
 */
public class UI {
    JFrame frame;
    JPanel panel;
    JButton send;
    JButton refresh;
    JTextField userTextBox;
    JTextArea textBox;
    Gson gson;


    public static void main(String[] args){
        UI ui = new UI();

    }
    public UI() {
        frame = new JFrame();
        panel = new JPanel();
        send = new JButton();
        refresh = new JButton();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(350,180));
        frame.setTitle("Chat");
        userTextBox = new JTextField(10);
        textBox = new JTextArea(5,20);
        send.setText("send");
        send.setBackground(Color.WHITE);
        refresh.setText("done");
        refresh.setBackground(Color.WHITE);
        frame.add(panel);
        frame.add(new JLabel("Sender: "));
        frame.add(textBox);
        frame.add(userTextBox);
        frame.add(send);
        frame.add(refresh);
        frame.add(new JLabel("Message"));
        frame.add(new JScrollPane(textBox));
        frame.setVisible(true);
        gson = new Gson();

        send.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String user= userTextBox.getText();
                String text= textBox.getText();
                Message message = new Message( "Corinne", user , text);
                String jSon = gson.toJson(message);
                //figure out how to send!!
            }
        });

    }
}
