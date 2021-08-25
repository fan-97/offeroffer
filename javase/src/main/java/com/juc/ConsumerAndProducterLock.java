package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerAndProducterLock {

    public static void main(String[] args) {
        Shop2 shop2 = new Shop2();
        Producter2 producter = new Producter2(shop2);
        Consumer2 consumer = new Consumer2(shop2);

        new Thread(producter, "生产者A").start();
        new Thread(consumer, "消费者B").start();
        new Thread(producter, "生产者C").start();
        new Thread(consumer, "消费者D").start();
    }
}

class Shop2 {

    private int stock;


    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void get() {
        lock.lock();
        try {
            while (stock >= 1) {

                System.out.println("库存已满");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(Thread.currentThread().getName() + "  当前库存量：  " + ++stock);
            condition.signalAll();
        } finally {
            lock.unlock();

        }
    }

    public synchronized void sale() {
        lock.lock();
        try {
            while (stock <= 0) {
                System.out.println("缺货");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "  当前库存量：  " + --stock);
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }
}

class Producter2 implements Runnable {

    private Shop2 shop2;

    public Producter2(Shop2 shop2) {
        this.shop2 = shop2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            shop2.get();
        }
    }
}

class Consumer2 implements Runnable {
    private Shop2 shop2;

    public Consumer2(Shop2 shop2) {
        this.shop2 = shop2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            shop2.sale();
        }
    }
}
