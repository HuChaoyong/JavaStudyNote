package GUI;

import javax.swing.*;
import java.awt.*;
import java.time.temporal.JulianFields;

public class Demo10 extends JFrame {
    JTextArea jta = null;
    JScrollPane jsp = null;
    JPanel jp1;
    JComboBox jcb = null;
    JTextField jtf = null;
    JButton jb = null;
    public static void main(String[] args) {
        Demo10 d10 = new Demo10();
    }

    public Demo10() {
        jta = new JTextArea();
        jp1 = new JPanel();
        jsp = new JScrollPane(jta);
        String[] chatter = {"布十", "本拉登"};
        jcb = new JComboBox(chatter);
        jtf = new JTextField(10);
        jb = new JButton("发送");
        //  设置布局
        jp1.add(jcb);
        jp1.add(jtf);
        jp1.add(jb);

        this.add(jsp);
        this.add(jp1, BorderLayout.SOUTH);
        this.setSize(300, 200);
        this.setIconImage(new ImageIcon("icon_QQ.png").getImage());
//        this.setIconImage(new ImageIcon("./icon_QQ.png").getImage());
        this.setTitle("腾讯QQ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
