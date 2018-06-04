import java.util.*; 
import java.io.*; 

public class Demo2 {
    public static void main(String[] args) throws Exception {
        // 创建 EmpManage 对象
        EmpManage manager = new EmpManage();
        // 做出一个简易的菜单

        // BufferedReader br = BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        while (true) {
            System.out.println("请选择你要进行的操作:");
            System.out.println("1. 表示添加一个雇员");
            System.out.println("2. 查找一个雇员");
            System.out.println("3. 修改一个雇员工资");
            System.out.println("4. 删除一个雇员");
            System.out.println("5. 退出系统");

            String opType = br.readLine();
            if (opType.equals("1")) {
                System.out.println("请输入编号:");
                String empNo = br.readLine();
                System.out.println("请输入名字:");
                String name = br.readLine();
                System.out.println("请输入工资:");
                float salary = Float.parseFloat(br.readLine());
                Emp emp = new Emp(empNo, name, salary);
                manager.addEmp(emp);
            } else if (opType.equals("2")) {
                System.out.println("请输入编号:");
                String empNo = br.readLine();
                manager.showInfo(empNo);
            } else if (opType.equals("5")) {
                // 退出系统
                System.exit(0);
            }
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