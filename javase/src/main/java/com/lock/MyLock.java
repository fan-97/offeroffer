package com.lock;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * @author fanjie
 * @date 2022/10/25 17:05
 */
public class MyLock {
    private final Sync sync = new Sync();
    public void lock() {
        sync.tryAcquire(1);
    }

    public void unlock() {
        sync.tryRelease(1);
    }

    private static class Sync extends AbstractQueuedLongSynchronizer {

        private static final long serialVersionUID = 99000577518310073L;

        @Override
        protected boolean tryAcquire(long arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(long arg) {
            return compareAndSetState(1, 0);
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        MyLock lock = new MyLock();
        Runnable task = () -> {
            try {
                lock.lock();
                for (int i = 0; i < 100; i++) {
                    num++;
                }
            } finally {
                lock.unlock();
            }

        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("num:" + num);
    }
}
