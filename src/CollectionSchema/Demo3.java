package CollectionSchema;

import java.util.*;

public class Demo3 {
    //   LinkList   链表列表
    // 有  addFirst 和  addLast
    public static void main(String[] args) {
        //
        // LinkList ll = new LinkList();
        // Emp emp1 = new Emp("sa01", "aa", 1.2f);
        // Emp emp2 = new Emp("sa02", "bb", 1.2f);
        // ll.addFirst(emp1);
        // ll.addFirst(emp2);

        Vector vv = new Vector();
        Emp empx1 =  new Emp("sa01", "aa", 1.2f);
        vv.add(empx1);

        // 栈
        Stack stacks = new Stack();


        // 创建一个 HashMap 对象
        HashMap hm = new HashMap();
        Emp emp11 = new Emp("s001", "aaa", 4.8f);
        Emp emp12 = new Emp("s002", "bbb", 5.6f);

        // 将 Emp 添加到 hm
        hm.put("s001", emp11);
        hm.put("s002", emp12);

        // 如果 你要查找 编号是 s002的这个人

        if (hm.containsKey("s002")) {
            System.out.println("有 s002的员工!");

            // 如何取出,
            Emp temp = (Emp)hm.get("s002");
            System.out.println(temp.toString());
        } else {
            System.out.println("没有 s002的员工!");
        }

        // 遍历哈希Map 中所有的key 和 value
        Iterator it = hm.keySet().iterator();
        // 返回一个boolean ,如果还有下一个东西,
        while (it.hasNext()) {
            // 取出 key
            String key = it.next().toString();
            // 通过key 取出 value
            Emp tempEmp = (Emp)hm.get(key);
            System.out.println(tempEmp.toString());
        }

        // HashTable
        Hashtable ht = new Hashtable();

        // Hashtable 是 同步的, 也就是说,为了保持数据的一致性, 会进行锁操作, 这样会更安全,但是,意味着开销更大
        // Hashmap 不是同步的,意味着更快

        // Hashtable 里面的 key 和 value 是不能放 null的
        // Hashmap 的 key 和value 是可以放 null的

        // Vector 有同步机制,  Vector 的增长速率,是 按照原来的 一倍来增长的 (如果数据量大的话,就用 Vector, 并且设置初始大小,避免不必要的开销
        // ArrayList 没有同步性, ArrayList 是按照50% 来增长的


    }
}