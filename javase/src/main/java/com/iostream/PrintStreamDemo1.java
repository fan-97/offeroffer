package com.iostream;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamDemo1 {
    public static void main(String[] args) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream("log.txt", true));
//        System.setOut(ps);
        ps.println("这是通过字节流的方式输出到文件");

        PrintWriter pw = new PrintWriter(new FileWriter("log.txt", true));

        pw.println("这是通过字符流的方式输出到文件");
        pw.flush();

    }
}
