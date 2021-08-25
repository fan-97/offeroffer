package com.iostream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReaderDemo1 {
    public static void main(String[] args) throws IOException {
        //将1~~6000的字符数据写入到文件 data.dat中
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("data.dat"));
            for (int i=1;i<=60000;i++){
                fw.write(i);
            }
        } catch (IOException e) {
            System.out.println("写入数据失败");
            System.exit(-1);
        }

        FileReader fr = new FileReader(new File("data.dat"));
        int b = 0;
        while((b=fr.read())!=-1){
            System.out.println(b);
        }


        fw.close();


    }
}
