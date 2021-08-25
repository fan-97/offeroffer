package com.socket.chatroom;

import java.io.*;
import java.net.Socket;

/**
 * @author Faster
 * @date 2020/3/12 10:43
 */
public class ChatClient extends ChatRoom {
    private Socket clientSocket;
    private BufferedWriter writer;
    private BufferedReader reader;

    public void send(String msg) throws IOException {
        if (!clientSocket.isOutputShutdown()) {
            writer.write(msg + "\n");
            writer.flush();
        }
    }

    public String receive() throws IOException {
        String msg = null;
        if (!clientSocket.isInputShutdown()) {
            msg = reader.readLine();
        }
        return msg;
    }
    @Override
    public void close() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void start() {
        try {
            clientSocket = new Socket(Constant.HOST,Constant.DEFAULT_PORT);
            //初始化流
            writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //向服务端发送消息
            new Thread(new UserInputHandler(this)).start();
            //接收服务端的消息
            while (true) {
                String msg = receive();
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }


}
