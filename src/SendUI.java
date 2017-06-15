
import com.google.gson.Gson;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by simone on 6/8/17.
 */
public class SendUI {
    static String url = "http://localhost:8000/messages";

    public static void main(String[] args) {
        Client client = new Client(url);

        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();
        final JButton send = new JButton();
        final JButton refresh = new JButton();
        final JTextField senderTextBox = new JTextField(10);
        final JTextField recieverTextBox = new JTextField(10);
        final JTextArea textBox = new JTextArea(5, 20);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(350, 180));
        frame.setTitle("Chat");

        send.setText("send");
        send.setBackground(Color.WHITE);
        refresh.setText("refresh");
        refresh.setBackground(Color.WHITE);

        frame.add(panel);
        frame.add(new JLabel("To: "));
        frame.add(textBox);
        frame.add(recieverTextBox);
        frame.add(new JLabel("From:"));
        frame.add(senderTextBox);
        frame.add(send);
        frame.add(refresh);
        frame.add(new JLabel("Message"));
        frame.add(new JScrollPane(textBox));
        frame.setVisible(true);
        Gson gson = new Gson();

        send.addActionListener(e ->  {
            String receiver = recieverTextBox.getText();
            String text = textBox.getText();
            String user = senderTextBox.getText();
            Message message = new Message(user, receiver , text);
            client.postRequest(message);
        });

    }

}
