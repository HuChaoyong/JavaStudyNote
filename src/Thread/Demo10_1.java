package Thread;

/**
 * 演示如何通过 thread 来开发线程
 *
 * 线程创建 =>  ( Runable(可运行状态) ====调度===>  Running（运行状态）  =========>  Blocked（阻塞状态）  )  =>  Dead （线程销毁）
 *                 <===========================循环===================================
 *
 *
 *  2种方法，
 *  A.  继承 Thread 类
 *  B.  实现 Runnable 接口
 */

public class Demo10_1 {

    public static void main(String[] args) {
//    Cat cat = new Cat();
//    cat.start();

        Dog dog = new Dog();
        dog.run();
    }
}


// 继承这个Thread 能够实现多线程
class Cat extends Thread {

    public void run() {
        int i = 0;
        while (true) {
            // 休眠 1秒，  1000毫秒
            // sleep 就会让该线程进入到  Blocked 状态，  并释放占用的 CPU 和内存
            try {
            Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            i ++;
            System.out.println("hello world!");

            if (i == 10) {
                break;
            }
        }
    }
}

// 实现这个接口也能够实现多线程
class Dog implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (true) {
            // 休眠 1秒，  1000毫秒
            // sleep 就会让该线程进入到  Blocked 状态，  并释放占用的 CPU 和内存
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            i ++;
            System.out.println("hello world!");

            if (i == 10) {
                break;
            }
        }
    }
}