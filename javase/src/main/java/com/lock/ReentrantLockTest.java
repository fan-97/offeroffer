package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fanjie
 * @date 2022/10/25 14:31
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        Lock nonfairReentrantLock = new ReentrantLock(false);
        Worker worker = new Worker(nonfairReentrantLock);
        Thread t1 = new Thread(worker);
        Thread t2 = new Thread(worker);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    static class Worker implements Runnable {
        private final Lock lock;

        public Worker(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ":get the lock");
            } finally {
                lock.unlock();
            }
        }
    }
}
