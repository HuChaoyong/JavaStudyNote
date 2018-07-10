package ExceptionDeal;

import java.io.*;
import java.net.Socket;

public class Test1 {
    public static void main(String[] args) {
        // 1. 检查异常,  编译器可以告诉你的异常
        // 打开文件异常, 比如找不到
        FileReader fr = null;
        try {
             fr= new FileReader("/home/hcy/shadow.sh");
            Socket s = new Socket("23.106.129.99", 80);
        } catch (FileNotFoundException e) {
            // 把异常的信息, 输出来,  有利于排查错误
            e.printStackTrace();

        } catch (IOException e2) {
            // 这个提示一般挺好使的
            e2.printStackTrace();
        } finally {
            //　这个语句块，　有没有出现异常，　这个块都会被执行
            //　一般说，　把某些资源关闭，　［文件，　数据库连接，　资源
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(" >???? ");




        // .连接一个 192.168.2.100, 比如端口找不到

        // Socket s = new Socket("23.106.129.100", 80);


        // 2.  运行异常,比如  数组越界, 0 被除,
        // int a = 4 / 0;
        // 数组越界
        //int arr[] = {0, 1, 2, 3};
        //System.out.println(arr[10]);


        // 3. 错误!   一般很少见, 也很难通过程序解决, 可能源于程序的bug



        // 异常的处理
        // 1. try ... catch  捕获异常



        // 2. finally
        // 如果吧 finally 放在 try ... catch 语句后面, finally 一般都会得到执行, 它相当于一个保险, 即使前面有异常, 而又没有捕获, finally 块 将会马上执行

    }
}
