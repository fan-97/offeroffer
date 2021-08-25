package com.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件输入流Demo1
 * 用字节流读取文件内容含有中文的时候会出现乱码
 * 原因是因为  字节流读取的单位是8位 一个字节
 * 中文的单位为16位  两个字节  所以每次读取都只能读取一半的字节  就会出现乱码。
 * 当有中文的时候，建议使用FileReader 每次读取一个字符，英文和中文都能正常显示
 */
public class FileInputStreamDemo1 {

    public static void main(String[] args) {

        int b = 0;//接收返回的数据字节

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("E:/java/cd5m/offeroffer/src/com/iostream/FileInputStreamDemo1.java"));
        } catch (FileNotFoundException e) {
            System.out.println("未找到指定文件");
            System.exit(-1);
        }

        int num = 0;//记录总共读取的字节数

        try {
            while ((b = fis.read()) != -1) {
                //读取到-1的时候说明已经到了文件末尾了
                System.out.print((char)b);
                num++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("总共读取了 "+num+" 个字节");
    }

}
