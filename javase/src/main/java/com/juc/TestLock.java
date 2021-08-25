package com.juc;

public class TestLock {
    public static void main(String[] args) {
        LockDemo ld = new LockDemo();
        new Thread(ld, "1号窗口").start();
        new Thread(ld, "2号窗口").start();
        new Thread(ld, "3号窗口").start();

    }
}

class LockDemo implements Runnable {

    private int ticket = 100;

    @Override
    public synchronized void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "   余票为：" + ticket--);
            } else {
                break;
            }
        }
    }


   /* @Override
    public void run() {
        //同步代码块
        while (true) {
            synchronized (this) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "   余票为：" + ticket--);
                } else
                    break;
            }
        }

    }*/
    /*Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
            lock.lock();
            try {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "   余票为：" + ticket--);
                } else
                    break;

            } finally {
                lock.unlock();
            }
        }
    }*/
    }
