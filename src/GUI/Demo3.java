package GUI;
import java.awt.*;
import javax.swing.*;
/**
 * 流式布局
 */
public class Demo3 extends JFrame {

    JButton jb1, jb2, jb3, jb4, jb5, jb6;

    public static void main(String[] args) {
        Demo3 d = new Demo3();
    }

    public Demo3 () {
        // 创建组件
        jb1 = new JButton("Aaaa");
        jb2 = new JButton("BBB");
        jb3 = new JButton("CCC");
        jb4 = new JButton("DDD");
        jb5 = new JButton("EEE");
        jb6 = new JButton("FFF");

        // 添加组件

        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(jb5);
        this.add(jb6);

        // 设置布局管理器

        this.setLayout(new FlowLayout());

        this.setTitle("UI布局的案例!");
        this.setSize(300, 200);
        this.setLocation(200, 200);

        // 禁止用户改变窗体大小
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示
        this.setVisible(true);
    }
}
