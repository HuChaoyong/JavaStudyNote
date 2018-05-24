public class Abstract {
    public static void main(String[] args) {}
}

// 抽象类
abstract class Animal {
    String name;
    int age;

    // 抽象方法
    abstract void scream();
}

// 继承抽象类，必须要实现抽象类的抽象方法
class Cat extends Animal {
    // 实现父类的 scream
    public void scream() {
        // ***
        System.out.println("喵瞄叫");
    }
}