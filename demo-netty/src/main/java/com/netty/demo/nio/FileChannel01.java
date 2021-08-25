package com.netty.demo.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过channel写入文件
 * @author fanjie
 * @date 2020/5/25 15:07
 */
public class FileChannel01 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("text.txt");

        //获取通道
        FileChannel channel = fos.getChannel();
        //创建buffer 指定大小为1024
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //向buffer中写入数据
        buffer.put("hello World!".getBytes());
        //将buffer从输入变成输出
        buffer.flip();
        //将buffer中的数据通过channel写出到文件
        channel.write(buffer);

        fos.close();
    }
}
