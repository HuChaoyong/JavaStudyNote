package Tank9;

/**
 *
 * 6  放置坦克重叠
 *     6.1  把判断方法写在坦克中
 *
 * 7 可以分关
 *     7.1 做一个开始的分关
 *     7.2 闪烁效果
 *     7.3 制作菜单
 * 8  实现暂停和继续  没做
 *
 * 9  单写一个记录类，记录还剩多少坦克
 *     9.1  用文件流
 *     ９.2　　单写一个记录类，完成对玩家的记录
 *     ９.3　　先完成保存共击毁多少辆坦克的功能
 *     9.4　存盘退出，　（记录存盘退出时的所有坦克的坐标）
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class TankGame extends JFrame implements ActionListener {
    MyPanel mp = null;

    //定义开始面板
    MyStartPanel msp = null;

    // 制作菜单

    JMenuBar jmb = null;
    // 开始游戏
    JMenu jm1 = null;
    JMenuItem jmi1 = null;
    JMenuItem jmi2 = null;
    JMenuItem jmi3 = null;
    JMenuItem jmi4 = null;

    public static void main(String[] args) {
        TankGame g1 = new TankGame();
    }

    public TankGame() {

        //创建菜单
        jmb = new JMenuBar();
        jm1 = new JMenu("游戏（G)");

        // 设置快捷方式
        jm1.setMnemonic('G');
        jmi1 = new JMenuItem("开始游戏(N)");
        // 对 jmi 响应
        jmi1.addActionListener(this);
        jmi1.setActionCommand("newGame");
        jmi1.setMnemonic('N');

        jmi2 = new JMenuItem("退出游戏(E)");
        jmi2.addActionListener(this);
        jmi2.setActionCommand("Exit");
        jmi2.setMnemonic('E');

        jmi3 = new JMenuItem("存盘退出游戏(Ｃ)");
        jmi3.addActionListener(this);
        jmi3.setActionCommand("saveExit");
        jmi3.setMnemonic('S');

        jmi4 = new JMenuItem("续上局游戏(Ｓ)");
        jmi4.addActionListener(this);
        jmi4.setActionCommand("continue");
        jmi4.setMnemonic('L');

        jm1.add(jmi1);
        jm1.add(jmi2);
        jm1.add(jmi3);
        jm1.add(jmi4);
        jmb.add(jm1);

        msp = new MyStartPanel();

        Thread t = new Thread(msp);
        t.start();

        this.setJMenuBar(jmb);
        this.add(msp);
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("newGame") ){
            mp = new MyPanel();
            // 先移除旧的面板 就是，开始面板
            this.remove(msp);
            // 然后，再把游戏开始面板加进去
            this.add(mp);
            Thread t = new Thread(mp);
            t.start();

            this.addKeyListener(mp);
            // 显示， 刷新 JFrame
            this.setVisible(true);
        } else if (e.getActionCommand().equals("Exit")) {
            //　用户点击了退出系统，　
            // 退出前，先保存数据

            Recorder.keepRecording();

            System.exit(0);
        } else if (e.getActionCommand().equals("saveExit")) {
            // 保存我方坦克的数量和坐标

            //　保存敌方坦克的位置和数量
            Recorder.setEts(mp.ets);
            Recorder.keepRecAndEnemyTank();
            // 退出
            System.exit(0);
        } else if (e.getActionCommand().equals("continue")) {

            //　继续存档的游戏
            mp = new MyPanel(Recorder.getNodesAndEnNums());
            // 先移除旧的面板 就是，开始面板
            this.remove(msp);
            // 然后，再把游戏开始面板加进去
            this.add(mp);
            Thread t = new Thread(mp);
            t.start();

            this.addKeyListener(mp);
            // 显示， 刷新 JFrame
            this.setVisible(true);
        }
    }
}

// 就是一个提示的作用，开始的面板
class MyStartPanel extends JPanel implements Runnable {

    boolean show = true;

    public void paint(Graphics g) {
        super.paint(g);

        // 绘制开始面板
        g.fillRect(0,0, 400, 300);


        if (show) {
            // 绘制关卡信息
            g.setColor(Color.YELLOW);
            // 开关信息的字体
            Font myFont = new Font("楷体", Font.BOLD, 30);
            g.setFont(myFont);
            g.drawString("Stage: 1", 120, 110);
        }

    }

    @Override
    public void run() {
        while (true) {
            // 休眠
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }

            this.show = !this.show;

            this.repaint();
        }
    }
}

class MyPanel extends JPanel implements KeyListener, Runnable {

    // 定义一个我的坦克

    Hero hero = null;

    boolean isPause = false;

    // 定义敌人坦克数组, 这里， 为了实现同步，线程安全， 必须采用 Vector， 而不能使用其他的
    Vector<EnemyTank> ets = new Vector<>();
    // define boom
    Vector<Bomb> bombs = new Vector<Bomb>();

    int enSize = 3;

    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    // constructor function
    public MyPanel() {

        // 恢复记录

        Recorder.getRecording();

        // 我的坦克
        hero = new Hero(100, 100);

        // 敌人的坦克
        for (int i = 0; i < enSize; i++) {
            EnemyTank et = new EnemyTank((i + 1) * 50, 0);
            // start enemy. (Thread)
            Thread t = new Thread(et);
            t.start();
            et.setColor(0);
            et.setDirect(2);
            ets.add(et);

            // 将mypanel的所有敌人坦克，交给该坦克
            et.setEts(ets);

            // 在敌方坦克创建时创建子弹
            Shot s = new Shot(et.x + 10, et.y + 30, et.direct);
            et.ss.add(s);
            Thread t2 = new Thread(s);
            t2.start();
        }
        // 另一种加载图片的方式（Ubuntu 未成功
        try {
            image1 = ImageIO.read(new File("/media/disk1/JavaStudy/src/1.png"));
            image2 = ImageIO.read(new File("/media/disk1/JavaStudy/src/2.png"));
            image3 = ImageIO.read(new File("/media/disk1/JavaStudy/src/3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // init images
//        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/1.png"));
//        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/2.png"));
//        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/3.png"));
    }

    public MyPanel(Vector<Node> nodes) {
        // 恢复记录

        Recorder.getRecording();

        // 我的坦克
        hero = new Hero(100, 100);

        // 敌人的坦克
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            EnemyTank et = new EnemyTank(node.x, node.y);
            // start enemy. (Thread)
            Thread t = new Thread(et);
            t.start();
            et.setColor(0);
            et.setDirect(node.direct);
            ets.add(et);

            // 将mypanel的所有敌人坦克，交给该坦克
            et.setEts(ets);

            // 在敌方坦克创建时创建子弹
            Shot s = new Shot(et.x + 10, et.y + 30, et.direct);
            et.ss.add(s);
            Thread t2 = new Thread(s);
            t2.start();
        }
        // 另一种加载图片的方式（Ubuntu 未成功
        try {
            image1 = ImageIO.read(new File("/media/disk1/JavaStudy/src/1.png"));
            image2 = ImageIO.read(new File("/media/disk1/JavaStudy/src/2.png"));
            image3 = ImageIO.read(new File("/media/disk1/JavaStudy/src/3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // 每隔100 毫秒， 重绘制

        while (true) {

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                this.hitEnemy();

                this.hitMe();

    //            this.preventCollision();

                // 重绘
                this.repaint();
            }
    }

    // 阻止碰撞
    public void preventCollision() {
        Vector<Tank> allTank = new Vector<Tank>();
        for (int i = 0; i < ets.size(); i++) {
            allTank.add(ets.get(i));
        }
        allTank.add(hero);
        for (int j = 0; j < allTank.size(); j++) {
            for (int k = 0; k < allTank.size(); k++) {
                Tank a = allTank.get(j);
                Tank b = allTank.get(k);
                if (a.id != b.id) {
                    if (a.judgeCollision(b) && a.id != hero.id) {
                        // 如果坦克要碰撞， 反向
                        a.setDirect((a.direct + 2) % 4);
                    }
                }
            }
        }
    }

    // 划出提示信息
    public void  showInfo(Graphics g) {
        //　划出提示信息的坦克（该坦克不参与战斗，）
        this.drawTank(100, 310, g, 0, 0);
        g.setColor(Color.black);
        g.drawString(Recorder.getEnNum() + "", 125, 320);


        this.drawTank(200, 310, g, 0, 1);
        g.setColor(Color.black);
        g.drawString(Recorder.getMyLife() + "", 225, 320);

        //　画出玩家击毁的坦克总数

        g.setColor(Color.black);
        g.drawString("您一共击毁了：" + Recorder.getDestroyEnNum() + "量坦克", 420, 30);
        this.drawTank(420, 60, g, 0 ,0 );
    }

    // 重新paint
    public void paint (Graphics g) {

        if (this.isPause) {
            return ;
        }

        super.paint(g);

        // 绘制背景框
        g.fillRect(0, 0, 400, 300);

        //　画出提示信息
        this.showInfo(g);


        if (hero.isLive) {
        // 绘制坦克
            this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 1);
        }

        // 画出坦克


        for (int i = 0; i < hero.ss.size(); i++) {
            // 遍历 子弹集合， 取出每颗子弹，并绘制

            Shot tp = hero.ss.get(i);

            if (tp != null && tp.isLive) {
                g.draw3DRect(tp.x, tp.y, 1, 1, false);
            }

            // 判断子弹是否消失。， 消失了就remove
            if (tp.isLive == false) {
                hero.ss.remove(tp);
            }
        }


        //  draw bomb, 绘制炸弹

        for (int i = 0; i < bombs.size(); i++) {
            // get bomb
            Bomb b = bombs.get(i);
            if (b.life > 6) {
                g.drawImage(image1, b.x, b.y, 30, 30, this);
            } else if (b.life > 3) {
                g.drawImage(image2, b.x, b.y, 30, 30, this);
            } else if (b.life > 0) {
                g.drawImage(image3, b.x, b.y, 30, 30, this);
            }
            b.lifeDown();

            if (!b.isLive) {
                bombs.remove(b);
            }
        }

        // 这里，不要用 恩Size， 使用 ets.size() 得到计算出来的坦克数量，坦克消失以后，数量就会改变
        for (int i = 0; i < ets.size(); i++) {
            EnemyTank t = ets.get(i);
            if (t.isLive) {
                this.drawTank(t.getX(), t.getY(), g,  t.getDirect(), 0);

                for (int j = 0; j < t.ss.size(); j++) {
                    // 取出子弹
                    Shot enemyShot = t.ss.get(j);
                    if (enemyShot.isLive) {
                        g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);
                    } else {
                        t.ss.remove(enemyShot);
                    }
                }
            }
        }
    }

    // 判断我的子弹是否击中敌人
    public void hitEnemy() {            // 判断子弹 和 坦克 是否碰撞  2 层for 循环
        for (int i = 0; i < hero.ss.size(); i++) {
            Shot tempShot = hero.ss.get(i);
            // 判断子弹是否有效

            if (tempShot.isLive) {
                for (int j = 0; j < ets.size(); j++) {
                    EnemyTank tempEnemyTank = ets.get(j);

                    if (tempEnemyTank.isLive) {
                        hitTank(tempShot, tempEnemyTank);
                    }
                }
            }
        }
    }

    // 判断敌方子弹是否击中我
    public void hitMe() {
        // 取出每个敌方坦克
        for (int i = 0; i < ets.size(); i++) {
            // 取出敌方坦克
            EnemyTank et = ets.get(i);

            // 取出所有的子弹
            for (int j = 0; j < et.ss.size(); j++) {
                Shot enemyShot = et.ss.get(j);
                if (hero.isLive) {
                    this.hitTank(enemyShot, hero);
                }
            }
        }
    }

    // 写一个函数， 专门判断子弹是否击中敌人

    public void hitTank(Shot s, Tank tank) {
        // 判断坦克的方向， 因为坦克的方向不是正方形，不同方向的范围不一样

        switch (tank.direct) {
            case 0:
            case 2:
                if (s.x > tank.x && s.x < tank.x + 20 && s.y > tank.y && s.y < tank.y + 30) {
                    // 击中坦克，
                    // 子弹会消亡，
                    s.isLive = false;
                    if (tank instanceof  EnemyTank) {
                      Recorder.reduceEnNum();
                    } else {
                        Recorder.reduceMyLife();
                    }
                    // 坦克会爆炸
                    tank.isLive = false;
                    // create a bomb, insert into Vector
                    Bomb b = new Bomb(tank.x, tank.y);
                    bombs.add(b);
                }
                break;
            case 1:
            case 3:
                if (s.x > tank.x && s.x < tank.x + 30 && s.y > tank.y && s.y < tank.y + 20) {
                    // 击中坦克，
                    // 子弹会消亡，
                    s.isLive = false;
                    if (tank instanceof  EnemyTank) {
                        Recorder.reduceEnNum();
                    } else {
                        Recorder.reduceMyLife();
                    }
                    // 坦克会爆炸
                    tank.isLive = false;
                    // create a bomb, insert into Vector
                    Bomb b = new Bomb(tank.x, tank.y);
                    bombs.add(b);
                }

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

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.isPause = !this.isPause;
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            // 按下 J， 表示 发射子弹
            // 控制只能发射5颗子弹
            if (this.hero.ss.size() <= 4) {
             this.hero.shotEnemy();
            }
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