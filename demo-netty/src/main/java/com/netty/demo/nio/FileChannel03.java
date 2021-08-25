package com.netty.demo.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 使用 FileChannel的transferFrom和transferTo进行文件拷贝
 * @author fanjie
 * @date 2020/5/25 17:06
 */
public class FileChannel03 {

    public static void main(String[] args) throws Exception{
        FileInputStream in = new FileInputStream("text.txt");
        FileOutputStream out = new FileOutputStream("2.txt");

        //获取通道
        FileChannel inChannel = in.getChannel();
        FileChannel outChannel = out.getChannel();

        //进行拷贝
//        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel,0,inChannel.size());

        out.close();
        in.close();
    }
}
