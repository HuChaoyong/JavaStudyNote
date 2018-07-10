package CollectionSchema;
import java.util.ArrayList;

public class Demo1 {
    // 集合, 讲 ArrayList, ArrayList 的长度是不定的, 并且,里面的类型是 Object
    public static void main(String[] args) {

        // Clerk clerks[] = new Cl

        ArrayList al = new ArrayList<>();

        Clerk c1 = new Clerk("松江", 30, 1000);
        Clerk c2 = new Clerk("吴用", 32, 1500);

        al.add(c1);
        al.add(c2);
        al.add(c1);
        al.add(c2);

        // Clerk temp = al.get(0);
        Clerk temp = (Clerk)al.get(3);
        System.out.println(temp.getName());
        al.remove(3);

        for (int i = 0; i < al.size(); i++) {
            Clerk t = (Clerk)al.get(i);
            System.out.println("名字:" + t.getName());
        }
    }
}

class Clerk {
    private String name;
    private int age;
    private float salary;

    public Clerk(String name, int age, float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }
}