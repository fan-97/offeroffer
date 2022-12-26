package com.example.springcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanjie
 * @date 2022/3/3 17:44
 */
@Service
public class BaseService {
    @Autowired
    private Aservice aservice;
    public void say() {
        System.out.println(BaseService.class.getName()+"===============");
    }
}
