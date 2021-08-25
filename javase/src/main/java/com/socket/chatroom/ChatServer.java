package com.socket.chatroom;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Faster
 * @date 2020/3/11 20:57
 */
public class ChatServer extends ChatRoom {
    private ServerSocket serverSocket;
    private Map<Integer, Writer> clientMap;//存放客户端的信息，端口 输出流

    public ChatServer() {
        clientMap = new HashMap<>();
    }

    /**
     * 添加客户端
     *
     * @param socket
     * @throws IOException
     */
    public synchronized void addClient(Socket socket) throws IOException {
        if (socket != null) {
            int port = socket.getPort();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            clientMap.put(port, writer);
            System.out.println(createMsg(port, "加入聊天室!"));
        }
    }

    /**
     * 移除客户端
     *
     * @param socket
     * @throws IOException
     */
    public synchronized void removeClient(Socket socket) throws IOException {
        if (socket != null) {
            Integer port = socket.getPort();
            Writer writer = clientMap.get(port);
            if (writer != null) {
                writer.close();
                clientMap.remove(port);
            }
            socket.close();
        }
        System.out.println(createMsg(socket.getPort(), "退出聊天室!"));
    }

    /**
     * 转发消息给每个客户端
     *
     * @param socket
     * @param msg
     * @throws IOException
     */
    public synchronized void forwardMsg(Socket socket, String msg) throws IOException {
        if (socket != null && msg != null) {
            for (Map.Entry<Integer, Writer> client : clientMap.entrySet()) {
                if (client.getKey() == socket.getPort()) continue;
                Writer writer = client.getValue();
                writer.write(msg + "\n");
                writer.flush();
            }
        }
    }

    public synchronized void close() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
                System.out.println("服务器关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(Constant.DEFAULT_PORT);
            System.out.println(String.format("服务器启动：[%s]", serverSocket.getLocalPort()));
            while (true) {
                Socket clientSocket = serverSocket.accept();
                //为每个客户端起一个处理线程
                new Thread(new ChatHandler(this, clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

}
