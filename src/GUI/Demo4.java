package GUI;

import java.awt.*;
import javax.swing.*;
public class Demo4 extends  JFrame{
    int size = 9;
    JButton jbs[] = new JButton[size];

    public static void main(String[] args) {
        Demo4 sd = new Demo4();
    }

    public Demo4() {
        for (int i = 0; i < size; i++) {
            // 创建组件
            jbs[i] = new JButton(String.valueOf(i));
        }

        // 设置网格布局
        // 3行 3列
        this.setLayout(new GridLayout(3, 3, 10, 10));

        for (int i = 0; i < size; i++) {
            this.add(jbs[i]);
        }

        // 设置窗体属性

        this.setTitle("网格布局案例");

        this.setSize(300, 200);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
