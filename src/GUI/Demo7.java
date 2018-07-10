package GUI;

import javax.swing.*;
import java.awt.*;

public class Demo7 extends JFrame {
    JPanel jp1, jp2, jp3;
    JButton jb1, jb2, jb3;
    JLabel jl1, jl2;
    JRadioButton jrb1, jrb2;
    JCheckBox jcb1, jcb2, jcb3;
    ButtonGroup bg;

    public static void main(String[] args) {
        Demo7 dd = new Demo7();
    }

    public Demo7() {
        // 创建组件
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jl1 = new JLabel("你喜欢的运动:");
        jl2 = new JLabel("你的性别:");

        jb1 = new JButton("注册用户");
        jb2 = new JButton("取消注册");

        jcb1 = new JCheckBox("足球");
        jcb2 = new JCheckBox("篮球");
        jcb3 = new JCheckBox("乒乓球");

        jrb1 = new JRadioButton("男");
        jrb2 = new JRadioButton("女");
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);

        // 设置1布局管理器

        this.setLayout(new GridLayout(3, 1));

        jp1.add(jl1);
        jp1.add(jcb1);
        jp1.add(jcb2);
        jp1.add(jcb3);

        jp2.add(jl2);
        jp2.add(jrb1);
        jp2.add(jrb2);

        jp3.add(jb1);
        jp3.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setTitle("Checkbox and Radio");
        this.setSize(300, 200);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示窗体
        this.setVisible(true);
    }
}
