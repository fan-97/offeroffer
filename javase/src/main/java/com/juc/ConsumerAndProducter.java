package com.juc;

/**
 * 生产者与消费者问题
 * 1.没有使用同步唤醒之前会产生 数据读取和修改错误
 * 2.使用同步唤醒可能会发生死锁：消费者线程结束了，生产者线程还在wait状态，无法唤醒
 * 3.解决了一直等待的问题，还会产生虚假唤醒现象，有多个线程进行同一种操作的时候，会出现同时等待，然后同时唤醒，导致数据溢出或者错误
 */
public class ConsumerAndProducter {

    public static void main(String[] args) {
        Shop2 shop = new Shop2();
        Producter2 producter = new Producter2(shop);
        Consumer2 consumer = new Consumer2(shop);
        new Thread(producter, "生产者A").start();
        new Thread(consumer, "消费者B").start();
        new Thread(producter, "生产者C").start();
        new Thread(consumer, "消费者D").start();
    }
}

class Shop {

    private int stock;

    public synchronized void get() {
        while (stock >= 1) {
            System.out.println("库存已满");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "  当前库存量：  " + ++stock);
        this.notifyAll();

    }

    public synchronized void sale() {
        while (stock <= 0) {
            System.out.println("缺货");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "  当前库存量：  " + --stock);
        this.notifyAll();

    }
}

class Producter implements Runnable {

    private Shop2 shop;

    public Producter(Shop2 shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            shop.get();
        }
    }
}

class Consumer implements Runnable {
    private Shop2 shop;

    public Consumer(Shop2 shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            shop.sale();
        }
    }
}