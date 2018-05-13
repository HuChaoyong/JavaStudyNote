// 多态的示例

public class polymorphism {
    public static void main(String[] args) {

        // Animal an = new Cat(); // 这是一个基本的多态的示例，如果不是多态，会写很多代码
        // an.scream();
        // an = new Dog();
        // an.scream();

        Master ms = new Master();
        ms.feed(new Dog(), new Bone());
    }
}

class Animal {
    String name;
    int age;
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge(String name) {
        return this.age;
    }

    // 动物会叫
    public void scream() {
        System.out.println("不知道怎么叫");
    }

    public void eat() { }
}

class Cat extends Animal {
    // 猫的叫声
    public void scream() {
        System.out.println("瞄瞄瞄");
    }
    
    @Override
    public void eat() {
        System.out.println("喵酱喜欢吃鱼哦");
    }
}

class Dog extends Animal {
    // 狗的叫声
    @Override
    public void scream() {
        System.out.println("汪汪汪");
    }

    @Override
    public void eat() {
        System.out.println("狗狗喜欢吃骨头");
    }
    
}

class Food {
    String name;
    public void showName() {

    }
}

class Fish extends Food {
    @Override
    public void showName() {
        System.out.println("鱼");
    }
}

class Bone extends Food {
    @Override
    public void showName() {
        System.out.println("骨头");
    }
}

// 主人类
class Master {
    // 给动物喂食，使用多态，方法就可以用一个

    public void feed (Animal animal, Food food) {
        animal.eat();
        food.showName();
    }
}