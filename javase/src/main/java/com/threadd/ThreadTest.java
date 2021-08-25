package com.threadd;

import java.util.concurrent.Callable;

public class ThreadTest {
    public static void main(String[] args) {
        Thead1 t1 = new Thead1();
        t1.start();
        Thread t2 = new Thread(new Runnable1());
        t2.start();
        System.out.println("main .....");
        CallableTest callableTest = new CallableTest();
        new Thread().start();
    }
}

class Thead1 extends  Thread{
    @Override
    public void run() {
        System.out.println("thred.........");
    }
}

class Runnable1 implements Runnable{

    @Override
    public void run() {
        System.out.println("implemnts runnable ");
    }
}
class CallableTest implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("callable");
        return null;
    }
}
