package com.example.springcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author fanjie
 * @date 2022/12/22 9:05
 */
@Service
public class Aservice {
    @Autowired
    private BService bService;
//    private final BaseService baseService;

//    public Aservice(BaseService baseService) {
//        this.baseService = baseService;
//    }

    @PostConstruct
    public void init(){
        System.out.println(bService);
        System.out.println("post construct");
    }

    public void proxyTest(){
        System.out.println("proxy test:"+this.getClass());
    }

}
