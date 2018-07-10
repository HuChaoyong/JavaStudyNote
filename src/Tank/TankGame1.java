package Tank;

import javax.swing.*;
import java.awt.*;

public class TankGame1 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame1 g1 = new TankGame1();
    }

    public TankGame1() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel {

    // 定义一个我的坦克

    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100); // 我的坦克
    }

    // 重新paint
    public void paint (Graphics g) {
        super.paint(g);

	g.fillRect(0, 0, 400, 300);

	this.drawTank(hero.getX(), hero.getY(), g, 0, 1);
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
		case 0:
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x + 15, y, 5, 30, false);
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			g.fillOval(x + 5, y + 10, 10, 10);
			g.drawLine(x + 10, y + 15, x + 10, y);
			break;
	}
    }
}

// 坦克类
class Tank {
    int x = 0;
    int y = 0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }





    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Hero extends Tank {

    public Hero(int x, int y) {
        super(x, y);
    }
}
