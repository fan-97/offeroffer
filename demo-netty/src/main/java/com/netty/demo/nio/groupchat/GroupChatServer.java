package com.netty.demo.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * 多人聊天室 服务端
 *
 * @author fanjie
 * @date 2020/6/17 9:50
 */
public class GroupChatServer {
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6666;

    public GroupChatServer() {
        init();
    }

    /**
     * 初始化服务端
     */
    private void init() {
        try {
            // 获取 选择器
            selector = Selector.open();
            // 打开ServerSocketChannel
            listenChannel = ServerSocketChannel.open();
            // 监听端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            // 设置非阻塞模式
            listenChannel.configureBlocking(false);
            // 注册Channel 到Selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听
     */
    public void listen() {
        try {
            while (true) {
                // 获取有IO操作的channel的个数
                int select = selector.select();
                if (select > 0) {
                    // 获取监听到的所有key
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        // 监听到连接事件
                        if (selectionKey.isAcceptable()) {
                            // 获取建立连接的通道
                            SocketChannel sc = listenChannel.accept();
                            sc.configureBlocking(false);
                            // 注册Channel 到 Selector
                            sc.register(selector, SelectionKey.OP_READ);
                            System.out.println(sc.getRemoteAddress() + " 上线！");
                        } else if (selectionKey.isReadable()) {
                            // 读取客户端的消息
                            readData(selectionKey);
                        }
                        //
                        iterator.remove();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取通道中的数据
     *
     * @param key
     */
    private void readData(SelectionKey key) {
        SocketChannel socketChannel = null;
        try {
            // 获取key 对应的channel
            socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 读取数据到buffer
            int buf = socketChannel.read(buffer);
            if (buf > 0) {
                String msg = new String(buffer.array(), 0, buf);
                System.out.printf("from 客户端[%s]:%s%n", socketChannel.getRemoteAddress() + "", msg);
                // 转发消息
                forwardMsg(msg, socketChannel);
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                System.out.println(socketChannel.getRemoteAddress() + "  已经离线！");
                socketChannel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * 转发消息给其他客户端
     *
     * @param msg
     * @param self 发送消息方
     */
    private void forwardMsg(String msg, SocketChannel self) {
        System.out.println("服务器转发消息中。。");
        // 获取所有的Channel
        selector.keys().stream()
                .map(key -> (Channel) key.channel())
                .filter(channel -> channel instanceof SocketChannel && !channel.equals(self))
                .forEach(targetChannel -> {
                    SocketChannel dest = (SocketChannel) targetChannel;
                    // 通过buffer将消息写入到通道
                    ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                    try {
                        dest.write(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
