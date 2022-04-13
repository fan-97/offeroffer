package com.netty.demo.netty.rpc.client.consumer;

import com.netty.demo.netty.rpc.api.service.SomeService;
import com.netty.demo.netty.rpc.client.client.RpcProxy;

public class RpcConsumer {
    public static void main(String[] args) {
        SomeService service = RpcProxy.create(SomeService.class);
        System.out.println(service.hello("kkb"));
        System.out.println(service.hashCode());
    }
}
