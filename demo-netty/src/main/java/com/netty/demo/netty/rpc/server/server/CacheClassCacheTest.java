package com.netty.demo.netty.rpc.server.server;

public class CacheClassCacheTest {
    public static void main(String[] args) throws Exception {
        new RpcServer().publish("com.abc.service");
    }
}
