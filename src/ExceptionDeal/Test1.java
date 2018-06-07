package ExceptionDeal;

import java.io.FileReader;
import java.net.Socket;

public class Test1 {
    public static void main(String[] args) {
        // 1. 检查异常,  编译器可以告诉你的异常
        // 打开文件异常, 比如找不到
        // FileReader fr = new FileReader("/home/hcy/a.txt");






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

    }
}
