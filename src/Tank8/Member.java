package Tank8;


import java.util.Vector;

// 坦克类
class Tank {
    // 坦克的 X 坐标
    // 坦克的 y坐标
    public static int count = 0;
    int id;
    int x = 0;
    int y = 0;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    int color;

    boolean isLive = true;

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

    // 判断当前坦克是否与其他坦克发生了碰撞， 并且阻止碰撞的发生
    // 1. 坦克范围，
    // 2.坦克下一次运动后的范围， 下一次运动的范围不能发生碰撞， 要是发生了，就反向
    public boolean judgeCollision(Tank anotherTank){
        int myX = this.x; // 当前坦克X
        int myY = this.y; // 当前坦克 Y
        int myAngX = 0; // 坦克对顶角位置X
        int myAngY = 0; // 坦克对顶角位置Y
        int anoX = anotherTank.x;
        int anoY = anotherTank.y;
        int anoAngX = 0;
        int anoAngY = 0;
        // 得出本坦克接下来即将到达的位置
        switch (this.direct) {
            case 0:
                myY -= speed;
                myAngX = myX + 20;
                myAngY = myY + 30;
                break;
            case 1:
                myX += speed;
                myAngX = myX + 30;
                myAngY = myY + 20;
                break;
            case 2:
                myY += speed;
                myAngX = myX + 20;
                myAngY = myY + 30;
                break;
            case 3:
                myX -= speed;
                myAngX = myX + 30;
                myAngY = myY + 20;
        }
        switch (anotherTank.direct) {
            case 0:
                anoY -= anotherTank.speed;
                anoAngX = anoX + 20;
                anoAngY = anoY + 30;
                break;
            case 1:
                anoX += anotherTank.speed;
                anoAngX = anoX + 30;
                anoAngY = anoY + 20;
                break;
            case 2:
                anoY += anotherTank.speed;
                anoAngX = anoX + 20;
                anoAngY = anoY + 30;
                break;
            case 3:
                anoX -= anotherTank.speed;
                anoAngX = anoX + 30;
                anoAngY = anoY + 20;
        }

        // 当左上角位置在对方坦克内部
        if (myX >= anoX && myX <= anoAngX && myY >= anoY && myY <= anoAngY) {
            return true;
        } else if (myAngX >= anoX && myAngX <= anoAngX && myAngY >= anoY && myAngY <= anoAngY) {
            // 当本坦克右下角位置在对方坦克内部
            return true;
        } else {
            return false;
        }
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
        this.id = count;
        count ++;
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
// upgrade enemy tank, support  Thread (it will run and shot )
class EnemyTank extends Tank implements Runnable {


    int times = 0;

    // 定义一个 Vector 存放敌方坦克的子弹

    Vector<Shot> ss = new Vector<Shot>();

    // 定义一个向量， 存放所有的敌方坦克

    Vector<EnemyTank> ets = new Vector<EnemyTank>();

    // 判断是否碰撞到别的敌坦克
    public boolean isTouchOtherEnemy() {
        boolean b = false;

        switch (this.direct) {
            case 0:
                // 该敌坦克方向向上
                for (int i = 0; i < ets.size(); i++) {
                    // 取出，并判断
                    EnemyTank et = ets.get(i);
                    if (et != this) {
                        // 与他判断的坦克方向向上下
                        if (et.direct == 0 || et.direct == 2) {
                            if (this.x >= et.x && this.x <= et.x + 20 && this.y >= et.y && this.y <= et.y + 30) {
                                return true;
                            }
                            if (this.x + 20 > et.x && this.x + 20 <= et.x + 20 && this.y >= et.y && this.y <= et.y + 30) {
                                return true;
                            }
                        }
                        if (et.direct ==1 || et.direct  == 3) {
                            if (this.x >= et.x && this.x <= et.x + 30 && this.y >= et.y && this.y <= et.y + 20) {
                                return true;
                            }
                            if (this.x + 20 > et.x && this.x + 20 <= et.x + 20 && this.y >= et.y && this.y <= et.y + 20) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                // 该敌坦克方向向右
                for (int i = 0; i < ets.size(); i++) {
                    // 取出，并判断
                    EnemyTank et = ets.get(i);
                    if (et != this) {
                        // 与他判断的坦克方向向上下
                        if (et.direct == 0 || et.direct == 2) {
                            if (this.x + 30 >= et.x && this.x + 30 <= et.x + 20 && this.y >= et.y && this.y <= et.y + 30) {
                                return true;
                            }
                            if (this.x + 30 > et.x && this.x + 30 <= et.x + 20 && this.y >= et.y && this.y <= et.y + 30) {
                                return true;
                            }
                        }
                        if (et.direct ==1 || et.direct  == 3) {
                            if (this.x + 30 >= et.x && this.x + 30 <= et.x + 30 && this.y + 20 >= et.y && this.y + 20 <= et.y + 20) {
                                return true;
                            }
                            if (this.x + 30 > et.x && this.x + 30 <= et.x + 20 && this.y >= et.y + 20 && this.y + 20 <= et.y + 20) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                // 该敌坦克方向向下
                for (int i = 0; i < ets.size(); i++) {
                    // 取出，并判断
                    EnemyTank et = ets.get(i);
                    if (et != this) {
                        // 与他判断的坦克方向向上下
                        if (et.direct == 0 || et.direct == 2) {
                            if (this.x >= et.x && this.x <= et.x + 20 && this.y + 30 >= et.y && this.y + 30 <= et.y + 30) {
                                return true;
                            }
                            if (this.x + 20 > et.x && this.x + 20 <= et.x + 20 && this.y + 30 >= et.y && this.y + 30 <= et.y + 30) {
                                return true;
                            }
                        }
                        if (et.direct ==1 || et.direct  == 3) {
                            if (this.x >= et.x && this.x <= et.x + 30 && this.y + 30 >= et.y && this.y + 30 <= et.y + 20) {
                                return true;
                            }
                            if (this.x + 20 > et.x && this.x + 20 <= et.x + 20 && this.y + 30 >= et.y && this.y + 30 <= et.y + 20) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < ets.size(); i++) {
                    // 取出，并判断
                    EnemyTank et = ets.get(i);
                    if (et != this) {
                        // 与他判断的坦克方向向上下
                        if (et.direct == 0 || et.direct == 2) {
                            if (this.x >= et.x && this.x <= et.x + 20 && this.y >= et.y && this.y <= et.y + 30) {
                                return true;
                            }
                            if (this.x  > et.x && this.x <= et.x + 20 && this.y >= et.y && this.y <= et.y + 30) {
                                return true;
                            }
                        }
                        if (et.direct ==1 || et.direct  == 3) {
                            if (this.x >= et.x && this.x <= et.x + 30 && this.y + 20 >= et.y && this.y + 20 <= et.y + 20) {
                                return true;
                            }
                            if (this.x > et.x && this.x <= et.x + 20 && this.y >= et.y + 20 && this.y + 20 <= et.y + 20) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }

        return b;
    }

    public void setEts(Vector<EnemyTank> vv) {
        this.ets = vv;
    }

    // 敌方添加子弹， 应该在刚创建的时候创建 和 敌方子弹消亡后

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public void run() {

        while (true) {
            switch (this.direct) {
                case 0: // enemy is going up
                    for (int i = 0; i < 30; i++) {
                        // 这里是判断坦克的行动范围，
                        if (y > 0 && !this.isTouchOtherEnemy()) {
                            y -= speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1: // enemy is going up
                    for (int i = 0; i < 30; i++) {
                        if (x < 400 && !this.isTouchOtherEnemy()) {
                            x += speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (y < 300 && !this.isTouchOtherEnemy()) {
                            y += speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (x > 0 && !this.isTouchOtherEnemy()) {
                            x -= speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            this.times ++;
            if (times % 2 == 0 && isLive && ss.size() < 5) {
                Shot s = null;
                System.out.println("添加一次子弹");
                // 敌方坦克没有子弹了
                // 在这里添加子弹
                switch (direct) {
                    case 0:
                        s = new Shot(x + 10, x, 0);
                        break;
                    case 1:
                        s = new Shot(x + 30, x + 10, 1);
                        break;
                    case 2:
                        s = new Shot(x + 10, x + 30, 2);
                        break;
                    case 3:
                        s = new Shot(x , x + 10, 3);
                        break;
                }
                ss.add(s);
                // 启动子弹的线程
                Thread t = new Thread(s);
                t.start();
            }

            // 判断是否需要给坦克加入新的子弹

            // let it generate a new direction
            this.direct = (int) (Math.random() * 4);

            // judge enemy is live ?
            if (!this.isLive) {
                // tank dead, and go out of Thread.
                break;
            }
        }
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


//            System.out.println("子弹坐标X=" + x + " Y =" + y);

            // 判断子弹的死亡.
            // 用边界来判断

            if (x < 0 || x > 400 || y < 0 || y > 300) {
                this.isLive = false;
                break;
            }
        }
    }
}

// boom

class Bomb {
    // define x,y
    int x, y;
    // boom's life
    int life = 9;
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // reduce life
    public void lifeDown() {
        if (life > 0) {
            life --;
        } else {
            this.isLive = false;
        }
    }
}