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
    JTextField userTextBox;
    JTextField textBox;


    public UI() {
        frame = new JFrame();
        panel = new JPanel();
        send = new JButton();
        frame.add(panel);
        panel.add(send);
        frame.setVisible(true);

        userTextBox = new JTextField();
        textBox = new JTextField();
        userTextBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.to = userTextBox.getText();
            }
        });
        textBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.message = userTextBox.getText();
            }
            Gson gson = new Gson;
            String json = gson.toJson(message);
            // now we just need to figure out how to send it
            
        });
