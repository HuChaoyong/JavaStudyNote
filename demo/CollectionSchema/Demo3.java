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
    }
}

// 员工管理类
class EmpManage {
    private ArrayList al = null;
    public EmpManage() {
        al = new ArrayList<>();
    }

    public void addEmp(Emp emp) {
        al.add(emp);
    }

    public void showInfo(String empNo) {
        // 遍历整个arrayList
        for (int i = 0; i < al.size(); i++) {
            // 取出,并比对
            Emp emp = (Emp) al.get(i);
            //  比较 empNO
            // 这里用  equals, 而不是用 ==
            // 字符串比较等不等,用 == 是比较地址等不等,不是比较内容
            if (emp.getEmpNo().equals(empNo)) {
                System.out.println("找到该员工, 信息:");
                System.out.println(emp.toString());
                break;
            }
        }
    }

    /**
     * 更新员工工资
     */
    public void updateEmpSalary(String empNo, float salary) {
        for (int i = 0; i < al.size(); i++ ) {
            Emp emp = (Emp) al.get(i);
            if (emp.getEmpNo().equals(empNo)) {
                emp.setSalary(salary);
                break;
            }
        }
    }

    /**
     * 删除员工
     */
    public void deleteEmp(String empNo) {
        for (int i = 0; i < al.size(); i++ ) {
            Emp emp = (Emp) al.get(i);
            if (emp.getEmpNo().equals(empNo)) {
                al.remove(i);
                break;
            }
        }
    }
}

// 员工类
class Emp {
    // 学号
    private String empNo;
    private String name;
    private float salary;
    // 构造函数
    public Emp(String empNo, String name, float salary) {
        this.empNo = empNo;
        this.name = name;
        this.salary = salary;
    }

    public String getEmpNo() {
        return this.empNo;
    }
    public String getName() {
        return this.name;
    }
    public float getSalary() {
        return this.salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public String toString() {
        return "编号:" + this.empNo + ", 姓名:" + this.name + ",薪资:" + this.salary;
    }
}