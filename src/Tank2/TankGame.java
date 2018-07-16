package Tank2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class TankGame extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame g1 = new TankGame();
    }

    public TankGame() {
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener {

    // 定义一个我的坦克

    Hero hero = null;

    // 定义敌人坦克数组, 这里， 为了实现同步，线程安全， 必须采用 Vector， 而不能使用其他的
    Vector<EnemyTank> ets = new Vector<>();
    int enSize = 3;

    public MyPanel() {
        // 我的坦克
        hero = new Hero(100, 100);

        // 敌人的坦克
        for (int i = 0; i < enSize; i++) {
            EnemyTank et = new EnemyTank((i + 1) * 50, 0);
            et.setColor(0);
            et.setDirect(2);
            ets.add(et);
        }

    }

    // 重新paint
    public void paint (Graphics g) {
        super.paint(g);

        g.fillRect(0, 0, 400, 300);

        this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 1);

        // 这里，不要用 恩Size， 使用 ets.size() 得到计算出来的坦克数量，坦克消失以后，数量就会改变
        for (int i = 0; i < ets.size(); i++) {
            EnemyTank t = ets.get(i);
            this.drawTank(t.getX(), t.getY(), g,  t.getDirect(), 0);
        }
    }

    public void drawTank(int x, int y, Graphics g,int direct, int type) {
        // pan duan shi shenme lei xing de tan ke
        switch(type){
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        switch(direct) {
            // 向上
            case 0:
                g.fill3DRect(x, y, 5, 30, false);
                g.fill3DRect(x + 15, y, 5, 30, false);
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                g.fillOval(x + 5, y + 10, 10, 10);
                g.drawLine(x + 10, y + 15, x + 10, y);
                break;
            case 1:
                g.fill3DRect(x, y, 30, 5, false);
                g.fill3DRect(x, y + 15, 30, 5, false);
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                g.fillOval(x + 10, y + 5, 10, 10);
                g.drawLine(x + 15, y + 10, x + 30, y + 10);
                break;
            case 2:
                g.fill3DRect(x, y, 5, 30, false);
                g.fill3DRect(x + 15, y, 5, 30, false);
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                g.fillOval(x + 5, y + 10, 10, 10);
                g.drawLine(x + 10, y + 15, x + 10, y + 30);
                break;
            case 3:
                g.fill3DRect(x, y, 30, 5, false);
                g.fill3DRect(x, y + 15, 30, 5, false);
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                g.fillOval(x + 10, y + 5, 10, 10);
                g.drawLine(x + 15, y + 10, x , y + 10);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            // 设置我的坦克的方向  向上
            this.hero.setDirect(0);
            this.hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            // 向右
            this.hero.setDirect(1);
            this.hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            // 向下
            this.hero.setDirect(2);
            this.hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            // 向左
            this.hero.setDirect(3);
            this.hero.moveLeft();
        }

        // 重新绘制

        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}