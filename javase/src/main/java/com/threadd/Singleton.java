package com.threadd;

import java.util.concurrent.Callable;

/**
 * 双重检验锁方式实现的单例模式
 * volatile 关键字修饰的变量 使其具备可见性，多个线程操作的时候不会发生安全隐患，因为操作的变量直接修改至内存中，而不是本地内存。synchronized
 */
public class Singleton implements Callable ,Runnable{

    private static volatile Singleton uniqueInstance;


    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class){
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public Object call() throws Exception {
        return null;
    }

    @Override
    public void run() {

    }
}
