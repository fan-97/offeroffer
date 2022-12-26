package com.example.springcode.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author fanjie
 * @date 2022/12/22 9:06
 */
@Aspect
@Component
public class AAsepct {
    @Pointcut(value = "execution(public * com.example.springcode.service.Aservice.proxyTest())")
    private void pointCutMethod() {
    }

    @After("pointCutMethod()")
    public void afterMethod() {
        System.out.println("after method");
    }

}
