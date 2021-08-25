package com.iostream;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo1 {
    public static void main(String[] args) throws Exception {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("test.txt"));
        osw.write("Hello World!");
        System.out.println(osw.getEncoding());
        osw.close();

    }
}
