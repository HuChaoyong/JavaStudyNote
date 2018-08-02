package io_use;
import java.io.*;

/**
 * BufferReader 和  BufferWriter
 *  直接操作 string
 *  操作粒度越来越大
 *
 *  演示缓冲字符流
 */
public class Demo11_6 {

    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;
        FileReader fr = null;
        FileWriter fw = null;

        try {

            // 先创建一个FileReader 对象，然后，再升级为
            fr = new FileReader("/home/hcy/Pictures/aaa.txt");
            br = new BufferedReader(fr);
            fw = new FileWriter("/home/hcy/Pictures/胡冲.txt");
            bw = new BufferedWriter(fw);
            // 读取文件
            String s = "";
            while ((s=br.readLine()) != null) {
                System.out.println(s);
                bw.write(s + "\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
                fr.close();
                fw.close();
            } catch (Exception e) {

            }
        }
    }
}
