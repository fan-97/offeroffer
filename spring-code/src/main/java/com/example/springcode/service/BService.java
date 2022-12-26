package com.example.springcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanjie
 * @date 2022/12/22 9:05
 */
@Service
public class BService {
    @Autowired
    private Aservice aservice;
}
