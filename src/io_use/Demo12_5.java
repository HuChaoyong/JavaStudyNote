package io_use;
import java.io.*;

/**
 * 演示文件字符流
 */


public class Demo12_5 {

    public static void main(String[] args) {

        // 读取字符流对象
        FileReader fr = null;
        // 写入文件字符流
        FileWriter fw = null;

        try {
            // 打开，创建一个 fr对象
            fr = new FileReader("/home/hcy/Pictures/aaa.txt");
            fw = new FileWriter("/home/hcy/Pictures/bbb.txt");
            // 读入到内存
            char[] c = new char[1024];
            fr.read(c);
            int n = 0; // 记录实际读取到的字符数
            while ((n=fr.read(c)) != -1) {
                System.out.println(c);
                fw.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
