package io_use;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * 记事本， 界面 + 功能
 */

public class NoteBook extends JFrame implements ActionListener {

    // 定义需要的组件

    // 文本框
    JTextArea jta = null;
    // 定义菜单栏
    JMenuBar jmb = null;
    JMenuItem jm1 = null;
    // 菜单栏选项
    JMenuItem jmi1 = null;
    JMenuItem jmi2 = null;
    JMenuItem jmi3 = null;

    public static void main(String[] args) {
        NoteBook s = new NoteBook();
    }

    public NoteBook() {
        jta = new JTextArea();
        jmb = new JMenuBar();
        jm1 = new JMenu("文件");
        // 设置注记符
        jm1.setMnemonic('F');
        jmi1 = new JMenuItem("打开", new ImageIcon("/open.png"));

        // 注册监听
        jmi1.addActionListener(this);
        // 这里设置这个用来在监听时判断
        jmi1.setActionCommand("open");
        jmi2 = new JMenuItem("保存");
        jmi2.addActionListener(this);
        jmi2.setActionCommand("save");
        jmi3 = new JMenuItem("退出");
        jmi3.addActionListener(this);
        jmi3.setActionCommand("exit");
        // 加入
        this.setJMenuBar(jmb);

        // 把jm1 放入到 jmb
        jmb.add(jm1);
        // 把item 放入到 Menu
        jm1.add(jmi1);
        jm1.add(jmi2);
        jm1.add(jmi3);

        // 放入到 JFrame中

        this.add(jta);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 判断是哪个菜单被打开
        if (e.getActionCommand().equals("open")) {
            System.out.println("打开");
            // 文件选择框(组件）
            JFileChooser jfc1 = new JFileChooser();
            // 打开窗口的标题
            jfc1.setDialogTitle("请选择文件");
            // 使用 “打开窗口”
            jfc1.showOpenDialog(null);
            // 显示
            jfc1.setVisible(true);

            // 得到用户选择的文件路径 （绝对路径）
            String filename = jfc1.getSelectedFile().getAbsolutePath();
            System.out.println(filename);

            FileReader fr = null;
            BufferedReader br = null;
            try {
                fr = new FileReader(filename);
                br = new BufferedReader(fr);

                String s = "";
                String allStr = "";
                while((s=br.readLine()) != null) {
                    allStr += s + "\r\n";
                }

                // 放置到 JTextArea 中
                jta.setText(allStr);

                // 从文件中读取信息，并显示到 JTextArea 中
            } catch (Exception er) {
                er.printStackTrace();
            } finally {
                try {
                    fr.close();
                    br.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equals("save")) {
            // 出现保存对话框
            // 文件选择框(组件）
            JFileChooser jfc1 = new JFileChooser();
            // 打开窗口的标题
            jfc1.setDialogTitle("另存为");
            // 使用 “保存窗口”
            jfc1.showSaveDialog(null);
            // 显示
            jfc1.setVisible(true);
            // 得到保存的路径
            String filename = jfc1.getSelectedFile().getAbsolutePath();

            // 准备 写入到指定文件

            BufferedWriter bw = null;
            FileWriter fw = null;

            try {
                fw = new FileWriter(filename);
                bw = new BufferedWriter(fw);

                String sss = this.jta.getText();



                bw.write(sss);

            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                try {
                    // 这里要记住关闭的顺序， 一定要先关闭 buffer, 再关闭 FileWriter
                    bw.close();
                    fw.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }  else if (e.getActionCommand().equals("exit")) {
            System.exit(0);
        }
    }
}
