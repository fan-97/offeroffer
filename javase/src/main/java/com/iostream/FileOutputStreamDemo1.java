package com.iostream;

import java.io.*;

/**
 * 文件输出流练习
 * 字节输出流当输出的内容占2个字节 也会出现乱码的前情况
 */
public class FileOutputStreamDemo1 {
    public static void main(String[] args) {
        int b = 0;
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(new File("offeroffer.iml"));//读取文件内容
            fos = new FileOutputStream(new File("test.txt"));//输出内容到文件
        } catch (FileNotFoundException e) {
            System.out.println("未找到指定文件");
            System.exit(-1);
        }

        try {
            while ((b=fis.read())!=-1){
                fos.write(b);
            }
        } catch (IOException e) {
            System.out.println("复制文件失败");
        }

        System.out.println("文件复制成功");

    }
}
