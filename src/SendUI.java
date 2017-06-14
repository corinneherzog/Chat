
import com.google.gson.Gson;
//import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by simone on 6/8/17.
 */
public class SendUI {
    static String url;
    static String user = "Corinne";

    public static void main(String[] args) {
        if(args[0].length() > 0){
            url = args[0];
        }
        else{
            url = "http://localhost:8000/messages";
        }
        Client client = new Client(url);

        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();
        final JButton send = new JButton();
        final JButton refresh = new JButton();
        final JTextField userTextBox = new JTextField(10);
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
        frame.add(userTextBox);
        frame.add(send);
        frame.add(refresh);
        frame.add(new JLabel("Message"));
        frame.add(new JScrollPane(textBox));
        frame.setVisible(true);
        Gson gson = new Gson();

        send.addActionListener(e -> {
            String receiver = userTextBox.getText();
            String text = textBox.getText();
            Message message = new Message(receiver, text);
            client.postRequest(message);
        });

    }

}

