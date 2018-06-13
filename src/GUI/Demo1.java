package GUI;

import java.awt.*;
import javax.swing.*;

public class Demo1 extends JFrame {
    // 把需要的 swing 组件定义在这里,
    JButton jb = null;
    public static void main(String[] args) {
        Demo1 d = new Demo1();
    }

    public Demo1 () {
        // JFrame 是一个顶层容器类,可以添加其他 swing类

        // 按钮
        JButton jb1 = new JButton("按钮1");

        // 设置标题
        this.setTitle("HelloWorld");

        // 设置大小
        this.setSize(200, 200);
        // 添加 按钮
        this.add(jb1);
        // 设置初始位置,
        this.setLocation(100, 200);

        // 退出时,关闭 javaw 进程, ;退出时,保证 jvm 也退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示
        this.setVisible(true);
    }
}
