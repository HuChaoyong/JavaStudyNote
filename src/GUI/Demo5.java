package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * 多种布局管理器的使用,  布局的嵌套
 */
public class Demo5 extends JFrame {
    // 定义组件
    JPanel jp1, jp2;
    JButton jb1, jb2, jb3, jb4, jb5, jb6;
    public static void main(String[] args) {
        Demo5 s = new Demo5();
    }

    public Demo5() {
        // 创建组将
        // Jpanel 是默认的流布局
        jp1 = new JPanel();
        jp2 = new JPanel();

        jb1 = new JButton("西瓜");
        jb2 = new JButton("苹果");
        jb3 = new JButton("荔枝");
        jb4 = new JButton("葡萄");
        jb5 = new JButton("橘子");
        jb6 = new JButton("香蕉");

        // 添加组件
        // 添加到 JPanel
        jp1.add(jb1);
        jp1.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        jp2.add(jb5);

        // 把 Panel 添加到 JFrame
        this.add(jp1, BorderLayout.NORTH);
        this.add(jb6, BorderLayout.CENTER);
        this.add(jp2, BorderLayout.SOUTH);

        this.setTitle("UI布局的案例!");
        this.setSize(300, 200);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示窗体
        this.setVisible(true);
    }
}
