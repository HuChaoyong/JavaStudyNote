package Tank2;

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

class Hero extends Tank {


    public Hero(int x, int y) {
        super(x, y);
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

class EnemyTank extends Tank {

    public EnemyTank(int x, int y) {
        super(x, y);
    }
}