package Tank;

/**
 * 功能： 讲解事件处理机制
 * 事件监听
 *  java 采用的是 委派事件模型， 即当事件发生时，事件的产生对象，会把信息传递给 “事件的监听者”， 这样的一种处理方式
 */

import GUI.Demo9;
import oracle.jrockit.jfr.JFR;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo9_3 extends JFrame implements ActionListener {

    // 定义一个panel
    JPanel mp3 = null;
    JButton jb1 = null;
    JButton jb2 = null;

    public static void main(String[] args) {
        Demo9_3 D = new Demo9_3();
    }

    public Demo9_3 () {
        mp3 = new JPanel();
        jb1 = new JButton("黑色");
        jb2 = new JButton("红色");

        this.add(jb1, BorderLayout.NORTH);
        mp3.setBackground(Color.black); // 设置背景颜色
        this.add(mp3);
        this.add(jb2, BorderLayout.SOUTH);

        // 事件监听的注册

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // 这个方法是 实现接口的

        if (e.getActionCommand() == "黑色") {
            this.mp3.setBackground(Color.black);
        } else if (e.getActionCommand() == "红色") {
            this.mp3.setBackground(Color.red);
        }

        System.out.println("233333333333");
    }


}

//class MyPanel3 extends  JPanel {
//
//    public  void paint (Graphics g) {
//        super.paint(g);
//
//        g.fillRect(0, 0, 200);
//    }
//}