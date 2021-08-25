package com.netty.demo.nio.groupchat.run;

import com.netty.demo.nio.groupchat.GroupChatClient;

import java.util.Scanner;

/**
 * @author fanjie
 * @date 2020/6/17 11:27
 */
public class ClientApplication {
    public static void main(String[] args) {
        GroupChatClient client = new GroupChatClient();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                client.readMsg();
            }
        }).start();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String msg = in.nextLine();
            client.sendMsg(msg);
        }
    }
}
