package com.netty.demo.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author fanjie
 * @date 2020/6/17 11:11
 */
public class GroupChatClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6666;
    private SocketChannel socketChannel;
    private Selector selector;
    private String username;

    public GroupChatClient() {
        init();
    }

    private void init() {
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            socketChannel.configureBlocking(false);
            // 注册channel
            socketChannel.register(selector, SelectionKey.OP_READ);
            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(username + " connection successfully!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向服务器发送消息
     *
     * @param msg
     */
    public void sendMsg(String msg) {
        msg = username + " 说：" + msg;
        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取服务器转发的消息
     */
    public void readMsg() {
        try {
            // 监听通道是否发生IO操作
            int select = selector.select();
            selector.selectedKeys().stream().forEach(key -> {
                if (key.isReadable()) {
                    try {
                        // 如果通道是可读的
                        SocketChannel channel = (SocketChannel) key.channel();
                        channel.configureBlocking(false);
                        // 创建buffer
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        // 将通道中的数据读取到buffer中
                        channel.read(buffer);
                        // 将消息打印到控制台中
                        String msg = new String(buffer.array());
                        System.out.println(msg.trim());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
