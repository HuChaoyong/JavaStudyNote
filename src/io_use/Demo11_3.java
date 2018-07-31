package io_use;
import java.io.*;

/**
 *  演示FileOutputStream
 */

public class Demo11_3 {
    public static void main(String[] args) {
        File f = new File("/home/hcy/Downloads/j2.txt");

        // 字节输出流
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(f);
            String s = "今天天晴呢～！～\n";

            String ss = "这是第二句话";

            fos.write(s.getBytes());
            fos.write(ss.getBytes());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
