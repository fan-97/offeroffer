package com.socket.chatroom;

/**
 * @author Faster
 * @date 2020/3/12 12:21
 */
public class Server {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.start();
    }
}
