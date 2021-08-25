package com.juc;

/**
 * 死锁
 * 两个线程互斥访问资源，争夺同一把锁出现死锁
 * 线程1拿着obj1的锁，去请求obj2的锁
 * 线程2拿着obj2的锁，去请求obj1的锁
 * 造成死锁
 */
public class TestDeadLock {

    public static Object obj1 = new Object();
    public static Object obj2 = new Object();

    public static void main(String[] args) {
        Lock1 lock1 = new Lock1();
        Lock2 lock2 = new Lock2();
        new Thread(lock1,"线程1").start();
//        new Thread(lock2,"线程2").start();
    }
}

class Lock1 implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"............");
            while(true){
                synchronized (TestDeadLock.obj1){
                    System.out.println(Thread.currentThread().getName()+"获取到了obj1的锁");
                    Thread.sleep(1000);
                    synchronized (TestDeadLock.obj2){
                        System.out.println(Thread.currentThread().getName()+"获取到了obj2的锁");
                    }
                    System.out.println(Thread.currentThread().getName()+"释放的obj2的锁");
                }
                System.out.println(Thread.currentThread().getName()+"释放的obj1的锁");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class  Lock2 implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"............");
            while(true){
                synchronized (TestDeadLock.obj2){
                    System.out.println(Thread.currentThread().getName()+"获取到了obj1的锁");
                    Thread.sleep(1000);
                    synchronized (TestDeadLock.obj1){
                        System.out.println(Thread.currentThread().getName()+"获取到了obj2的锁");
                    }
                    System.out.println(Thread.currentThread().getName()+"释放的obj2的锁");
                }
                System.out.println(Thread.currentThread().getName()+"释放的obj1的锁");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
