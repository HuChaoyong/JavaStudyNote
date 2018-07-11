package Tank;

/**
 * 功能： 加深对事件对象的处理
 * 1. 通过键盘，控制小球的移动
 *  nice
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Demo9_4 extends JFrame {

    MyPanel4 mp4 = null;

    public static void main(String[] args) {
        Demo9_4 d94 = new Demo9_4();
    }

    public Demo9_4() {
        mp4 = new MyPanel4();

        this.add(mp4);

        this.addKeyListener(mp4);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setVisible(true);
    }
}


class MyPanel4 extends JPanel implements KeyListener {

    int x = 10;
    int y = 10;

    public void paint(Graphics g) {
        super.paint(g);

        g.fillOval(this.x, this.y, 10, 10);


    }

    @Override // 代表具体的键的值
    public void keyTyped(KeyEvent e) {

    }

    @Override // 键盘按下
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S) {
            this.y ++;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            this.y --;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.x --;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            this.x ++;
        }

        // 调用repaint 来重绘

        this.repaint();
    }

    @Override // 键盘松开
    public void keyReleased(KeyEvent e) {

    }
}