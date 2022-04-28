package com.netty.demo.netty.rpc.server.server;

public class RpcStarter {
    public static void main(String[] args) throws Exception {
        RpcServer server = new RpcServer();
        server.publish("com.netty.demo.netty.rpc.server.service");
        server.start();
    }
}
