import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 约瑟夫问题
 */

public class Ysfwt {
    public static void main(String[] args) {
        System.out.println("program run!");
        CycLink C = new CycLink();
        C.setLen(5);
        C.initLink();
        C.show();
        C.play(2, 2);
    }
}

// 小孩
class Child {
    int no;
    Child nextChild = null;

    public Child(int idx) {
        this.no = idx;
    }
}

// 环形链表
class CycLink {
    Child firstChild = null; // 第一个孩子
    Child temp = null;
    int len = 0; // 链表的长度

    public void setLen(int len) {
        this.len = len;
    }

    public void initLink() {
        for (int i = 0; i < len; i++) {
            Child ch = new Child(i);
            if (i == 0) {
                // 创建第一个小孩
                this.firstChild = ch;
                this.temp = ch;
            } else if (i == len - 1) {
                // 处理最后一个小孩
                this.temp.nextChild = ch;
                ch.nextChild = this.firstChild;
            } else {
                this.temp.nextChild = ch;
                this.temp = ch;
            }
        }
    }

    /**
     * k 第K个人开始数 m 数m次
     */
    public void play(int k, int m) {
        // 1 .先找到数数的人
        // 2.数到m下
        // 3.将数到m的小孩，退出圈
        Child temp = this.firstChild;
        for (int i = 1; i < k; k++) {
            temp = temp.nextChild;
        }

        while (this.len != 1) {
            // 数 m 下
            for (int j = 1; j < m; j++) {
                temp = temp.nextChild;
            }

            Child temp2 = temp;
            while (temp2.nextChild != temp) {
                temp2 = temp2.nextChild;
            }
            temp2.nextChild = temp.nextChild;
            temp = temp.nextChild;
            this.len--;
        }
        // 最后一个小孩
        System.out.println("最后一个小孩" + temp.no);
    }

    public void show() {
        // 定义游标
        Child temp = this.firstChild;
        do {
            System.out.println(temp.no);
            temp = temp.nextChild;
        } while (temp != this.firstChild);
    }
}