package io_use;

import java.io.File;
import java.io.IOException;

public class Demo11_1 {
    public static void main(String[] args) {
        // 创建一个文件对象
        File f = new File("/home/hcy/ganzi.sh");
        // 得到文件的路径
        System.out.println("file path: " + f.getAbsolutePath());

        // get size of file
        System.out.println("file size:" + f.length());

        System.out.println(" can read :" + f.canRead());

        System.out.println(" can read :" + f.canWrite());

        // create file and directroy

        /*
        File f2 = new File("/home/hcy/Downloads/javaCreate.txt");
        // 判断文件是否存在
        if (!f2.exists()) {
            // 文件不存在， 可以创建
            try {
                f2.createNewFile();
                System.out.println("文件 创建成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 文件存在， 不能创建
            System.out.println("文件已存在，不能创建");
        }
        */


        File f3 = new File("/home/hcy/Downloads/newDirect");
        if (f.isDirectory()) {
            System.out.println("文件夹已存在！");
        } else {
            // 创建文件夹
            // ubuntu 下不成功！！！！
            f.mkdirs();
            System.out.println("创建文件夹成功");
        }


        // 列出文件夹下所有文件
        File f4 = new File("/home/hcy/Downloads");

        if (f.isDirectory()) {
            // 列出来
            File[] list =  f.listFiles();

            // ubuntu 下 失效
            for (int i = 0; i < list.length; i++) {
                System.out.println("文件名:" + list[i].getName());
            }
        }


        // 读取操作


    }
}
