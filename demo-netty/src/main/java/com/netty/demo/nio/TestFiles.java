package com.netty.demo.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author fanjie
 * @date 2022/4/14 20:00
 */
public class TestFiles {
    public static void main(String[] args) throws IOException {
        String source = "D:\\temp1111";
        String target = "D:\\temp1111bak";

        Files.walk(Paths.get(source)).forEach(file -> {
            try {
                String targetName = file.toString().replace(source,target);
                if(Files.isDirectory(file)){
                    Files.createDirectory(Paths.get(targetName));
                }else{
                    Files.copy(file,Paths.get(targetName));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
