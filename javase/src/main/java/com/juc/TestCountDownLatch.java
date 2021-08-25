package com.juc;

import java.util.concurrent.CountDownLatch;

/**
 * 练习CountDownLatch的使用
 * CountDownLatch :
 * @author fan
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        DemoLatch demoLatch = new DemoLatch(countDownLatch);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(demoLatch).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("共执行：" + (end - start) + "毫秒");
    }
}

class DemoLatch implements Runnable {

    private final CountDownLatch latch;

    public DemoLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
//        synchronized (this) {
        try {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        } finally {
            latch.countDown();
        }

//        }
    }
}
