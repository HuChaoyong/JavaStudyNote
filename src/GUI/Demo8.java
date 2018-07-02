package GUI;

/**
 * 下拉列表选择
 * 和 内容box
 */

import javax.swing.*;
import java.awt.*;

public class Demo8 extends JFrame {
    JPanel jp1, jp2, jp3;
    JLabel jl1, jl2;
    JComboBox jcb1;
    JList jlist;
    JScrollPane jsp;

    public static void main(String[] args) {
        Demo8 d8 = new Demo8();
    }

    public Demo8() {
        jp1 = new JPanel();
        jp2 = new JPanel();

        jl1 = new JLabel("你的籍贯:");
        jl2 = new JLabel("你喜欢去的旅游地:");

        String[] jg = {"成都", "重庆", "宜宾"};
        jcb1 = new JComboBox(jg);

        String[] address = {"都江堰", "青城山", "九寨沟", "峨眉山", "故宫", "黄山"};
        jlist = new JList(address);
        jlist.setVisibleRowCount(3);
        jsp = new JScrollPane(jlist);
        // 设置你希望显示多少个选项

        this.setLayout(new GridLayout(3, 1));

        jp1.add(jl1);
        jp1.add(jcb1);

        jp2.add(jl2);
        jp2.add(jlist);

        this.add(jp1);
        this.add(jp2);


        this.setTitle("下拉列表 和 slider BOx");
        this.setSize(300, 200);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示窗体
        this.setVisible(true);
    }
}
