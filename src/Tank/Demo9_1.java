package Tank;

import javax.swing.*;
import java.awt.*;

/**
 * 功能:java 绘图原理
 */

public class Demo9_1 extends JFrame{

    MyPanel1 mp = null;

    public static void main(String[] args) {
        Demo9_1 s = new Demo9_1();
    }

    public Demo9_1() {
        mp = new MyPanel1();

        this.add(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

// 定义一个MyPanel 用于绘图和显示绘图的区域
class MyPanel1 extends JPanel {
    // 只有panel 才能绘图
    // 覆盖  JPanel 的  paint 方法

    // repaint()  刷新组件的外观
    public void paint(Graphics g) {
        // 1. 调用父类, 完成初始化任务
        //  这句话是必须的,不能少
        super.paint(g);

        System.out.println("2333333");

        // 画个圆
        g.drawOval(10, 10, 30, 30);

        // 绘制直线
        g.drawLine(10, 10, 40, 50);

        // 绘制矩形边框
        g.drawRect(10, 10, 40, 60);

        // 绘制填充矩形
//        g.setColor(Color.blue);
//        g.fillRect(70, 70, 40, 60);
//
//        g.setColor(Color.red);
//        g.fillRect(150, 150, 40, 50);

        // 在面板上画出图片

//        Image im = Toolkit.getDefaultToolkit().getImage
//                (Panel.class.getResource("/no.jpg"));
//        // 实现
//        g.drawImage(im, 90, 90, 200, 150, this);

        g.setColor(Color.blue);
        g.setFont(new Font("华文彩云", Font.BOLD, 29));
        g.drawString("羊酱", 100, 100);


    }
}
