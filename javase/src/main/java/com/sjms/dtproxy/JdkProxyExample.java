package com.sjms.dtproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {

    //真实的对象
    private Object target= null;

    /**
     * 绑定代理对象和真实对象
     * @param target
     * @return 代理对象
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调用真实对象之前的服务");
        Object object = method.invoke(target,args);
        System.out.println("在调用真实对象之后的服务");
        return object;
    }

}
