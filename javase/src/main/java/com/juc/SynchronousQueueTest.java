package com.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;

/**
 * @author fanjie
 * @date 2021/9/6 9:03
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        Future future = service.submit(() -> {
            int a = 2/0;
            System.out.println(111);
        });
//        new Thread(()->{
//            try {
//                queue.put(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(()->{
//            try {
//                System.out.println(queue.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }
}
