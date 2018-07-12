package Tank;

import javax.swing.*;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.awt.*;
import java.awt.event.*;

public class Demo9_5 extends JFrame {

    MyPanel5 mp5 = null;

    public static void main(String[] args) {

        Demo9_5 d = new Demo9_5();
    }

    public Demo9_5() {
        mp5 = new MyPanel5();
        this.add(mp5);

        this.addMouseListener(mp5);
        this.addMouseMotionListener(mp5);
        this.addWindowListener(mp5);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }

}

/**
 * 1. 让 MyPanel 知道鼠标按下的消息， 并且知道点击的位置
 *
 * 2. 让 MyPanel 知道哪个按键被按下
 *
 * 3. 让 MyPanel 知道鼠标移动，拖拽
 *
 * 4. 让 MyPanel 知道窗口的变化，（最小化， 最大化， 关闭）
 */

class MyPanel5 extends JPanel implements MouseListener, MouseMotionListener, WindowListener {

    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override // 点击
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击了" + e.getX() + ", " + e.getY());
    }

    @Override // 鼠标按下
    public void mousePressed(MouseEvent e) {

    }

    @Override // 鼠标放开
    public void mouseReleased(MouseEvent e) {

    }

    @Override // 鼠标移入
    public void mouseEntered(MouseEvent e) {

    }

    @Override  // 鼠标移出
    public void mouseExited(MouseEvent e) {

    }



    @Override // 鼠标拖动
    public void mouseDragged(MouseEvent e) {

    }

    @Override  // 鼠标移动
    public void mouseMoved(MouseEvent e) {
        System.out.println("鼠标当前坐标: X=" + e.getX() + ",Y=" + e.getY());
    }



    @Override // 窗口打开
    public void windowOpened(WindowEvent e) {
        System.out.println("窗口打开了呀～");
    }

    @Override  // 窗口正在关闭
    public void windowClosing(WindowEvent e) {

    }

    @Override // 窗口关闭了
    public void windowClosed(WindowEvent e) {

    }

    @Override //
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override // 窗口激活
    public void windowActivated(WindowEvent e) {

    }

    @Override // 窗口最小化
    public void windowDeactivated(WindowEvent e) {

    }
}
