package io_use;
import java.io.*;

/**
 * how to readfile (FileInputStream)
 */


public class Demo11_2 {
    public static void main(String[] args) {
        File f = new File("/home/hcy/UbuntuDoc/UbuntuDoc/nginx.txt");

        // 因为， File没有读和写的能力， 所以，需要 使用 InputStream流

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(f);

            // 定义一个字节数组, 相当于缓存了， 如果文件很大，它是一点一点的读，读了再写入内存
            byte[]  bArr = new byte[1024];
            int n = 0; // 得到实际读取到的字节数
            // 循环读取
            while ((n=fis.read(bArr)) != -1) {
                // 把字节转成 string
                String s = new String(bArr, 0, n);
                // 打印
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 一定要关闭文件流！！！   不关有没有异常，都要执行这里
            try {
              fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
