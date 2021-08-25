package com.netty.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));

        // 读取文件的每一行 然后进行处理 并重新写入到新文件中
        String s = br.readLine();
        BufferedWriter bw = new BufferedWriter(new FileWriter("A_1.txt"));
    }
}
