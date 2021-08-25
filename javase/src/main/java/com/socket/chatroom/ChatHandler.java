package com.socket.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Faster
 * @date 2020/3/12 10:10
 */
public class ChatHandler implements Runnable {
    private ChatServer chatServer;
    private Socket clientSocket;
    private BufferedReader reader = null;

    public ChatHandler(ChatServer chatServer, Socket clientSocket) {
        this.chatServer = chatServer;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try {
            //添加客户端到服务器中
            chatServer.addClient(clientSocket);
            //接收客户端发送的消息
             reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String msg = null;
            while ((msg = reader.readLine()) != null) {
                if (chatServer.readyQuit(msg)) {
                    chatServer.forwardMsg(clientSocket, chatServer.createMsg(clientSocket.getPort(), "退出聊天室!"));
                    break;
                }
                String newMsg = String.format("客户端[%s]:%s", clientSocket.getPort(), msg);
                System.out.println(newMsg);
                //转发消息给其他客户端
                chatServer.forwardMsg(clientSocket,newMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                chatServer.removeClient(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
