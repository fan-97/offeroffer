package com.base;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Faster
 * @date 2019/9/17 17:05
 */
public class Test {
    private static final ThreadPoolExecutor sleepThreadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue<>());
    private static final ThreadPoolExecutor taskThreadPool = new ThreadPoolExecutor(4, 4, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            int finalI = i;
            sleepThreadPool.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+"   sleep 5s  index:"+ finalI);
                    Thread.sleep(1000);
                    task();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void task() {
        taskThreadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ":task");
        });
    }

    public static void change(A a) {
        a.i = 20;
        A aa = new A();
        a = aa;
        System.out.println(aa.i + "  " + a.i);
    }
}

class A {
    public int i = 15;
}
