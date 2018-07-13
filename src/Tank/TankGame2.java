package Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 功能： 坦克游戏 2.0
 * 1. 画出坦克
 * 2. 能够上下左右移动
 */

public class TankGame2 extends JFrame {
    MyPanel6 mp6 = null;

    public static void main(String[] args) {

    }

    public TankGame2() {
        mp6 = new MyPanel6();

        this.add(mp6);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }
}

class MyPanel6 extends JPanel implements KeyListener {

    Hero  hero = null;

    public MyPanel6() {
        hero = new Hero(100, 100);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

