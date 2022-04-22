package com.netty.demo.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fanjie
 * @date 2022/4/14 20:28
 */
public class Server {
    public static void main(String[] args) {
        List<SocketChannel> clientList = new ArrayList<>();
        try {
            ServerSocketChannel server = ServerSocketChannel.open();
            server.configureBlocking(false);
            ServerSocket socket = server.socket();
            socket.bind(socket.getLocalSocketAddress());
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                Socket accept = socket.accept();
                SocketChannel channel = accept.getChannel();
                channel.read(buffer);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
