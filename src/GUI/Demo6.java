package GUI;

import javax.swing.*;
import java.awt.*;

public class Demo6 extends JFrame {
    JPanel jp1, jp2, jp3;
    JLabel jlb1, jlb2;
    JButton jb1, jb2;
    JTextField jtf1;
    JPasswordField jtf2;

    public static void main(String[] args) {
        Demo6 sd = new Demo6();
    }

    public Demo6() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jlb1 = new JLabel("用户名");
        jlb2 = new JLabel("密    码");

        jb1 = new JButton("登录");
        jb2 = new JButton("取消");

        jtf1 = new JTextField(10);
        jtf2 = new JPasswordField(10);

        this.setLayout(new GridLayout(3, 1));
        // 添加组件

        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jtf2);

        jp3.add(jb1);
        jp3.add(jb2);

        // 加入到  JFrame
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setSize(300, 150);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("会员管理系统");

        this.setVisible(true);
    }
}
