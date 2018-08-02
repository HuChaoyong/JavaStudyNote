package io_use;


import java.io.*;

/**
 * picture copy
 */

public class Demo11_4 {

    public static void main(String[] args) {
        // 先读入，再写入新文件

        FileInputStream fis = null;

        // 定义输出流

        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("/home/hcy/Pictures/d3.jpg");
            fos = new FileOutputStream("/home/hcy/Pictures/copy.jpg");

            byte[]  buf = new byte[1024];

            // 用来记录实际读取到的字节数
            int n = 0;
            // 循环读取，
            while((n=fis.read(buf)) != -1) {
                // 输出到指定文件
                fos.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
