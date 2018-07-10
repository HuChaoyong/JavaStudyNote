package ExceptionDeal;

import java.io.FileReader;

public class Test2 {
    public static void main(String[] args) {

    }
}

class Father {
    private  Son son1 = null;
    public Father() {
        son1 = new Son();
    }
    public void test1() {
        System.out.println("1");
//        son1.test2();
    }
}

class Son {
    public void test2() throws Exception {
        FileReader fr = null;
        fr = new FileReader("/home/hcy/aaa.txt");
    }
}
