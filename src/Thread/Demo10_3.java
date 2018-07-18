package Thread;

/**
 *  使用线程的注意事项.
 *   1. 一个线程对象，只能启动一个线程.    t.start(); 只能跑一次
 */

public class Demo10_3 {
    public static void main(String[] args) {
        Fish f = new Fish();
        Monkey m = new Monkey();

        Thread t = new Thread(m);
        Thread t2 = new Thread(m);

        t.start();
        t2.start();

        f.start();
//        f.start();
    }
}

class Fish extends Thread {

    public void run() {
        System.out.println("run Fish Thread");
    }

}

class Monkey implements Runnable {

    @Override
    public void run() {
        System.out.println("run Monkey Thread");
    }
}