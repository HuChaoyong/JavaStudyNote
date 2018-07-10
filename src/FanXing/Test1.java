package FanXing;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<Dog> alist = new ArrayList<Dog>();
        // 创建一只狗
        Dog dog1 = new Dog();
        // 放入到集合中
        alist.add(dog1);


//    Cat temp = (Cat)al.get(0); // 这句话会隐藏安全隐患 如果里面存的是狗,而取出来强行转换成猫, 这样会造成编译异常
        Dog temp = alist.get(0); // 这样,在取出来的时候,默认就会知道,取出来的,绝对只可能是 Dog,就不用强行转换
    }
}

class Cat {
    private  String color;
    private int age;
    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {

        return color;
    }

    public int getAge() {
        return age;
    }
}

class Dog {
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}