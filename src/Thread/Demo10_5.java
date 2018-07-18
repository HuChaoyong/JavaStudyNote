package Thread;

public class Demo10_5 {

    public static void main(String[] args) {
        TicketWindow t1 = new TicketWindow();
        TicketWindow t2 = new TicketWindow();
        TicketWindow t3 = new TicketWindow();



        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t1);
        Thread th3 = new Thread(t1);

        th1.start();
        th2.start();
        th3.start();
    }
}

// 售票窗口类

class TicketWindow implements Runnable {

    private RedDog rd = new RedDog();

    //　一共2000张票
    private int nums = 2000;

    public void run() {

        while (true) {

            // 同步代码块   (代表这个对象本身）
            // 这个对象锁是任意对象都可以。  （ 对象锁的状态为1 时，可随意进行。 为 0 时， 无法进入对象锁里面的代码块）
            synchronized (rd) {


                // 判断是否还有票
                if (nums > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在售出第" + nums + "张票");
                    nums--;
                // 出票速度  一秒一张
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

class RedDog {

}