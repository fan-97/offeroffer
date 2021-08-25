package com.sjms.dtproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyExample implements MethodInterceptor {

    /**
     * 获取代理对象
     * @param cls  目标对象class
     * @return  代理对象
     */
    public Object getProxy(Class cls){
        //Cglib enhancer增强类对象
        Enhancer enhancer = new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象为当前对象
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用真实对象之前");
        Object obj = methodProxy.invokeSuper(o,objects);
        System.out.println("调用真实对象之后");
        return obj;
    }
}
