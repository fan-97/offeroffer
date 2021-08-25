package com.iostream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        int b = 0;
        FileInputStream fis = new FileInputStream("offeroffer.iml");
        BufferedInputStream bis = new BufferedInputStream(fis);
//        System.out.println((char) bis.read());
//        System.out.println((char) bis.read());

        bis.mark(1);//在第20个字符处标记
        for (int i = 0; i < 10 && (b = bis.read()) != -1; i++) {
            System.out.print((char) b);
        }
        System.out.println();
        bis.reset();//让光标位置重新回到标记处
        b = 0;
        for (int i = 0; i < 10 && (b = bis.read()) != -1; i++) {
            System.out.print((char) b);
        }
        System.out.println();
        bis.reset();//让光标位置重新回到标记处
        b = 0;
        for (int i = 0; i < 10 && (b = bis.read()) != -1; i++) {
            System.out.print((char) b);
        }
    }
}
