package com.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程顺序执行
 *
 * @author fanjie
 * @date 2022/10/25 19:59
 */
public class PrintThead {
    public static final int THREAD_A = 0;
    public static final int THREAD_B = 1;
    public static final int THREAD_C = 2;

    public static int threadCode = 0;

    public static void main(String[] args) {
//        Object lock = new Object();
//        new Thread(new Worker(lock, 0)).start();
//        new Thread(new Worker(lock, 1)).start();
//        new Thread(new Worker(lock, 2)).start();

        // condition and lock
        new Thread(new Worker2(0)).start();
        new Thread(new Worker2(1)).start();
        new Thread(new Worker2(2)).start();
    }

    static class Worker2 implements Runnable {
        private static final ReentrantLock lock = new ReentrantLock();
        private static final Condition condition = lock.newCondition();

        private final int threadCode;

        Worker2(int threadCode) {
            this.threadCode = threadCode;
        }

        @Override
        public void run() {
            // 使用 lock和condition
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
//                    System.out.println(this.threadCode + ": get lock");
                    while (this.threadCode != PrintThead.threadCode) {
                        condition.await();
                    }
                    System.out.printf("%c", 'A' + this.threadCode);
                    PrintThead.threadCode = (PrintThead.threadCode + 1) % 3;
                    if (this.threadCode == 2) {
                        System.out.println();
                    }
                    condition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Worker implements Runnable {
        private final Object lock;
        private final int threadCode;

        Worker(Object lock, int threadCode) {
            this.lock = lock;
            this.threadCode = threadCode;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    System.out.println(this.threadCode + ": get lock");
                    while (this.threadCode != PrintThead.threadCode) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.printf("%c", 'A' + this.threadCode);
                    PrintThead.threadCode = (PrintThead.threadCode + 1) % 3;
                    if (this.threadCode == 2) {
                        System.out.println();
                    }
                    lock.notifyAll();
                }
            }
        }
    }
}
