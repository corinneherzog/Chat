
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

/**
 * Created by simone on 6/8/17.
 */
public class UI {
    Message message;
    JFrame frame;
    JPanel panel;
    JButton send;
    JButton done;
    JTextField userTextBox;
    JTextArea textBox;

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
        frame.setSize(new Dimension(350,180));
        frame.setTitle("Chat");
        userTextBox = new JTextField(10);
        textBox = new JTextArea(5,20);
        send.setText("send");
        send.setBackground(Color.WHITE);
        done.setText("done");
        done.setBackground(Color.WHITE);
        frame.add(panel);
        frame.add(new JLabel("Sender: "));
        frame.add(textBox);
        frame.add(userTextBox);
        frame.add(send);
        frame.add(done);
        frame.add(new JLabel("Message"));
        frame.add(new JScrollPane(textBox));
        frame.setVisible(true);

        send.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String user= userTextBox.getText();
                String text= textBox.getText();
                Timestamp time = new Timestamp(System.currentTimeMillis());
                Message message = new Message( "Corinne", user , time , text);
                System.out.println(message.toString());
            }
        });
    }
}
