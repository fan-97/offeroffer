package com.threadd;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者例子
 *
 * @author fanjie
 * @date 2022/9/16 17:49
 */
public class ProduceAndConsumeTest {
    //1 .使用condition和Lock
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static boolean flag = false;

    public static void main(String[] args) throws Exception {

        Thread consume = new Thread(new Test.Consume(), "Consume");
        Thread produce = new Thread(new Test.Produce(), "Produce");
        consume.start();
        Thread.sleep(1000);
        produce.start();

        try {
            produce.join();
            consume.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 生产者线程
    static class Produce implements Runnable {

        @Override
        public void run() {
            lock.lock();

            System.out.println("进入生产者线程");
            System.out.println("生产");
            try {
                TimeUnit.MILLISECONDS.sleep(2000);  //模拟生产过程
                flag = true;
                condition.signal();  //通知消费者
                TimeUnit.MILLISECONDS.sleep(1000);  //模拟其他耗时操作
                System.out.println("退出生产者线程");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    //消费者线程
    static class Consume implements Runnable {

        @Override
        public void run() {
            lock.lock();
            System.out.println("进入消费者线程");
            System.out.println("wait flag 1:" + flag);
            while (!flag) {  //判断条件是否满足，若不满足则等待
                try {
                    System.out.println("还没生产，进入等待");
                    condition.await();
                    System.out.println("结束等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("wait flag 2:" + flag);
            System.out.println("消费");
            System.out.println("退出消费者线程");
            lock.unlock();

        }
    }

}
