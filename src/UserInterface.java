import javax.swing.*;
import java.awt.*;

public class UserInterface {
    public static void main(String[]args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(300,150));
        frame.setTitle("Text frame");
        JTextArea area = new JTextArea(5,20);
        frame.add(area);
        frame.add(new JScrollPane(area));
        JButton button1 = new JButton();
        button1.setText("send");
        button1.setBackground(Color.WHITE);
        JButton button2 = new JButton();
        button2.setText("done");
        button2.setBackground(Color.WHITE);
        frame.add(button1);
        frame.add(button2);
        frame.setVisible(true);
    }
}
