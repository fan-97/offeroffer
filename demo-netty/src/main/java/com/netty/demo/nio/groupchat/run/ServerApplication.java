package com.netty.demo.nio.groupchat.run;

import com.netty.demo.nio.groupchat.GroupChatServer;

/**
 * @author fanjie
 * @date 2020/6/17 10:53
 */
public class ServerApplication {
    public static void main(String[] args) {
        GroupChatServer chatServer = new GroupChatServer();
        chatServer.listen();
    }
}
