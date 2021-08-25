package com.iostream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.txt"));
        for(int i=48;i<100;i++) {
            bos.write((char)i);
        }
        bos.flush();
    }
}
