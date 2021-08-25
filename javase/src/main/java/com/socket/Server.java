package com.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Faster
 * @date 2020/3/7 19:26
 */
public class Server {
    public static void main(String[] args) {
        final String QUIT = "quit";
        final int DEFAULT_SERVER_PORT = 9999;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(DEFAULT_SERVER_PORT);
            System.out.println("服务器已启动,监听端口：[" + DEFAULT_SERVER_PORT + "]");
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("客户端[" + client.getPort() + "]连接");
                //获取客户端输入流 和输出流
                BufferedReader clientReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter clientWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                String msg = null;
                //获取客户端的消息
                while ((msg = clientReader.readLine()) != null) {
                    System.out.println("客户端[" + client.getPort() + "]:" + msg);
                    //向客户端反馈信息
                    clientWriter.write("I got it\n");
                    clientWriter.flush();
                    if (msg.equals(QUIT)) {
                        System.out.println("客户端[" + client.getPort() + "]断开连接");
                        break;
                    }
                }
                //关闭流
                if (clientReader != null) {
                    clientReader.close();
                }
                if (clientWriter != null) {
                    clientWriter.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("服务端连接已断开");
        }
    }
}
