package FanXing;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) {
//        1
        Gen<Bird> gen1 = new Gen<Bird>(new Bird());
        gen1.showTypeName();
    }
}

// 定义一个鸟类

class Bird {

    public void test1() {
        System.out.println("aa");
    }
    public void count(int a, int b) {
        System.out.println(a + b);
    }
}

// 定义一个类
class Gen<T> {
    private T o;

    // 通过泛型的反射机制, 可以得到, 类的 成员函数名,
    // 得到T的类型名称
    public void showTypeName() {
        System.out.println("类型是: " + o.getClass().getName());
        Method[] m =  o.getClass().getDeclaredMethods();

        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i].getName());
        }
    }

    public Gen (T a) {
        o = a;
    }
}
