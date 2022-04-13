package com.netty.demo.netty.rpc.server.service;

import com.netty.demo.netty.rpc.api.service.SomeService;

public class SomeServiceImpl implements SomeService {
    @Override
    public String hello(String name) {
        return name + "欢迎你";
    }
}
