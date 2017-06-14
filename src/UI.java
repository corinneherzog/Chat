
import com.google.gson.Gson;
//import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.methods.HttpGet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by simone on 6/8/17.
 */
public class UI {
    static String url;
    static HttpClient client = HttpClientBuilder.create().build();
    static String user = "Corinne";

    public static void main(String[] args) {
        if(args[0].length() > 0){
            url = args[0];
        }
        else{
            url = "http://localhost:8000/messages";
        }
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton send = new JButton();
        JButton refresh = new JButton();
        JTextField userTextBox = new JTextField(10);
        JTextArea textBox = new JTextArea(5, 20);

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
        ClientUI clientui = new ClientUI();
        ArrayList<Message> list = new ArrayList<>();
        Message message2 = new Message("Corinne", "Brendan" , "hi");
        Message message1 = new Message("Brendan" , "Corinne" , "hello");
        list.add(message2);
        list.add(message1);
        clientui.addTextBoxes(list);

        send.addActionListener(e -> {
            String receiver = userTextBox.getText();
            String text = textBox.getText();
            Message message = new Message(receiver, text);
            String jSon = gson.toJson(message);
            postRequest(jSon);
        });

      /*  refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Message> list = getRequest(gson);
                for (int i = 0; i < list.size(); i++)
                    textBox.setText(list.get(i).text);

            }

        });
        */
    }

   public static void postRequest(String jSon) {
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-type", "application/json");
        post.setHeader("user", user);

        try {
            StringEntity input = new StringEntity(jSon);
            input.setContentType("application/json");
            post.setEntity(input);
            client.execute(post);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //OK SO THE POST WORKS!!!
}

