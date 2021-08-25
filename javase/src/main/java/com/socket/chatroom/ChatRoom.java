package com.socket.chatroom;

/**
 * @author Faster
 * @date 2020/3/12 11:52
 */
public abstract class ChatRoom {

    public abstract void start();
    public abstract void close();

    public String createMsg(int port, String msg) {
        return String.format("客户端[%s]:%s\n", port, msg);
    }

    public boolean readyQuit(String msg){
        return Constant.QUIT.equals(msg);
    }
}
