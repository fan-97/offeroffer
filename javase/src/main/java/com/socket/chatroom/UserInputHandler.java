package com.socket.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Faster
 * @date 2020/3/12 12:05
 */
public class UserInputHandler implements Runnable {

    private ChatClient client;

    public UserInputHandler(ChatClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        try {
            while ((msg = consoleReader.readLine())!=null) {
                //发送消息
                client.send(msg);
                if(client.readyQuit(msg)){
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }
}
