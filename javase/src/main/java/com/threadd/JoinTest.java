package com.threadd;

/**
 * @author fanjie
 * @date 2022/9/5 17:34
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> System.out.println("thread 1"));
        Thread t2 = new Thread(() -> System.out.println("thread 2"));
        Thread t3 = new Thread(() -> System.out.println("thread 3"));
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
