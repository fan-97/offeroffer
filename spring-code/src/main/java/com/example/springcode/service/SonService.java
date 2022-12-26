package com.example.springcode.service;

import javax.annotation.PostConstruct;

/**
 * @author fanjie
 * @date 2022/3/3 17:47
 */
//@Service
public class SonService extends BaseService{
    @Override
    public void say() {
        System.out.println(SonService.class.getName()+"=================");
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }
}
