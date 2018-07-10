package GUI;

/**
 *  Border 布局
 * 1. 继承 JFrame
 * 2. 定义你需要的组件
 * 3. 创建组件 (在构造函数里面 ,)
 * 4. 把组件添加到 界面
 * 5. 设置窗体的属性
 */

import java.awt.*;
import javax.swing.*;

public class Demo2 extends JFrame {

    // 定义组件

    JButton jb1, jb2, jb3, jb4, jb5;

    public static void main(String[] args) {
        Demo2 d = new Demo2();
    }

    public Demo2() {
        // 创建组件
        jb1 = new JButton("中部");
        jb2 = new JButton("北部");
        jb3 = new JButton("东部");
        jb4 = new JButton("南部");
        jb5 = new JButton("西部");

        // 添加各个组件
        this.add(jb1, BorderLayout.CENTER);
        this.add(jb2, BorderLayout.NORTH);
        this.add(jb3, BorderLayout.EAST);
        this.add(jb4, BorderLayout.SOUTH);
        this.add(jb5, BorderLayout.WEST);

        // 设置窗体的属性

        this.setTitle("UI布局的案例!");
        this.setSize(300, 200);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示窗体
        this.setVisible(true);
    }

}
