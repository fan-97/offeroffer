package com.netty.demo.nio;


import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过channel读入文件
 *
 * @author fanjie
 * @date 2020/5/25 15:15
 */
public class FileChannel02 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("text.txt");

        //创建Channel
        FileChannel channel = fis.getChannel();
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(fis.available());
        //从channel中获取数据到buffer中
        channel.read(buffer);

        System.out.println(new String(buffer.array()));

    }
}
