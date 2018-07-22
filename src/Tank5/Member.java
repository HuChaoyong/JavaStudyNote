package Tank5;

import java.util.Vector;

// 坦克类
class Tank {
    // 坦克的 X 坐标
    // 坦克的 y坐标
    int x = 0;
    int y = 0;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    int color;

    // 坦克的方向
    // 0 表示上， 1 表示 右， 2 表示下，  3表示 左
    int direct = 0;

    // 为了方便以后扩展， 给坦克加个速度

    // 坦克的速度

    int speed = 1;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

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

// 我方坦克
class Hero extends Tank {

    Vector<Shot> ss = new Vector<Shot>();
    Shot s = null;

    public Hero(int x, int y) {
        super(x, y);

    }

    // 发射子弹

    public void shotEnemy() {

        switch (this.direct) {
            case 0:
                s = new Shot(x + 10, y, 0);
                break;
            case 1:
                s = new Shot(x + 30, y + 10, 1);
                break;
            case 2:
                s = new Shot(x + 10, y + 30, 2);
                break;
            case 3:
                s = new Shot(x , y + 10, 3);
                break;
        }
        ss.add(s);

        // 启动子弹线程

        Thread t = new Thread(s);
        t.start();

    }

    // 坦克向上移动

    public void moveUp() {
        y -= speed;
    }

    public void moveRight() {
        x += speed;
    }
    public void moveDown() {
        y += speed;
    }
    public void moveLeft() {
        x -= speed;
    }

}

// 敌方坦克
class EnemyTank extends Tank {

    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }
}

// 子弹
class Shot implements Runnable {
    int x;
    int y;
    int direct;
    int speed = 1;
    boolean isLive = true; // 子弹默认存活的

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }

            switch (this.direct) {
                case 0:
                    this.y -= speed;
                    break;
                case 1:
                    this.x += speed;
                    break;
                case 2:
                    this.y += speed;
                    break;
                case 3:
                    this.x -= speed;
                    break;
            }


            System.out.println("子弹坐标X=" + x + " Y =" + y);

            // 判断子弹的死亡.
            // 用边界来判断

            if (x < 0 || x > 400 || y < 0 || y > 300) {
                this.isLive = false;
                break;
            }
        }
    }
}