package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * 词霸;
 */

public class Demo9 extends JFrame {
    JSplitPane jsp;
    JList jlist;
    JLabel jl1;
    public static void main(String[] args) {
        Demo9 d9 = new Demo9();
    }

    public Demo9() {
        String[] words = {"boy", "girl", "bird"};
        jlist = new JList(words);

        jl1 = new JLabel(new ImageIcon("../../no.jpg"));

        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jlist, jl1);

        // 设置布局管理器
        this.add(jsp);
        this.setSize(300, 200);
        this.setLocation(100, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
