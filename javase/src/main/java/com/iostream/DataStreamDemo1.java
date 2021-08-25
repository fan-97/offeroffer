package com.iostream;

import java.io.*;

public class DataStreamDemo1 {
    public static void main(String[] args) throws IOException {
        //调用构造方法的时候会在内存中创建一个ByteArray字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //套接上一层数据流，用来处理int double 类型的数据
        DataOutputStream dos = new DataOutputStream(baos);
        //写入的数据都会存放在  ByteArrayOutputStream  的Byte 数组buf里面
        dos.writeBoolean(false); //写入boolean类型的数据
        dos.writeDouble(Math.random());

        //读取刚刚的数据，要按照存放的顺序读取
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        System.out.println(bais.available());
        //包装一层数据流，用来读取int double 类型的数据
        DataInputStream dis = new DataInputStream(bais);
        System.out.println(dis.readBoolean());
        System.out.println(dis.readDouble());

    }
}
