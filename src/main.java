/**
 * Created by ros_crherzog on 5/9/2017.
 */
public class main {
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
        frame.add(button1);
        frame.setVisible(true);
    }
}
