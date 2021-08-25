package com.socket;

import java.io.*;
import java.net.Socket;
import java.util.Date;

import static com.socket.DateTimeUtil.dateFormatter;

/**
 * @author Faster
 * @date 2020/3/8 11:16
 */
public class Client {
    public static void main(String[] args) {
        final int SERVER_PORT = 9999;
        final String QUIT = "quit";
        final String SERVER_HOST = "127.0.0.1";
        try(Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter serverWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //从控制台输入信息
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.println(dateFormatter(new Date())+":连接成功[" + SERVER_HOST + ":" + SERVER_PORT + "]");
            String msg = null;
            while ((msg = consoleReader.readLine()) != null) {
                serverWriter.write(msg+"\n");
                serverWriter.flush();
                String resMsg = serverReader.readLine();
                System.out.println(dateFormatter(new Date())+":服务端:"+resMsg);
                if(QUIT.equals(msg)){
                    System.out.println(dateFormatter(new Date())+":断开连接");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
