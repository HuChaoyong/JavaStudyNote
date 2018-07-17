package Thread;

/**
 * 两个线程同时运行的案例
 */

public class Demo10_2 {

    public static void main(String[] args) {
        Pig p = new Pig(10);
        Bird b = new Bird(15);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
    }

}


// 鸟去算数学题
class Bird implements Runnable {

    int n = 0;
    int res = 0;
    int times = 0;

    public Bird(int n) {
        this.n = n;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            times ++;
            res += times;

            System.out.println("当前结果是：" + res);

            if (times == n) {
                System.out.println("最后结果是:" + res);
                break;
            }
        }
    }
}

class Pig implements Runnable {

    int n = 0;

    int times = 0;

    public Pig(int n ) {
        this.n = n;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            times ++;
            System.out.println("我是一个线程， 在输出" + times + "个 HelloWorld!");

            if (times == n) {
                break;
            }
        }
    }
}