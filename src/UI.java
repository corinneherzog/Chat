import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by corinne on 6/7/17.
 */
public class UI {
    Message message;
    JFrame frame;
    JPanel panel;
    JButton send;
    JButton done;
    JTextField userTextBox;
    JTextField textBox;

    public static void main(String[] args){
        UI ui = new UI();

    }
    public UI() {
        frame = new JFrame();
        panel = new JPanel();
        send = new JButton();
        done = new JButton();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(300,175));
        frame.setTitle("Chat");
        userTextBox = new JTextField(10);
        textBox = new JTextField(10);



        send.setText("send");
        send.setBackground(Color.WHITE);
        done.setText("done");
        done.setBackground(Color.WHITE);
        frame.add(new JScrollPane());
        frame.add(send);
        frame.add(done);
        frame.add(panel);
        frame.add(textBox);
        frame.add(userTextBox);
        frame.setVisible(true);



        userTextBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.to = userTextBox.getText();
            }
        });

        textBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.message = userTextBox.getText();
                Gson gson = new Gson();
                String json = gson.toJson(message);
                        // now we just need to figure out how to send it
            }
        });
    }
}