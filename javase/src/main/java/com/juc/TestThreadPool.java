package com.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService  cacheThreadPool = Executors.newCachedThreadPool();
        //为线程分配任务
//        for (int k = 0;k<10;k++) {
//            cacheThreadPool.submit(() -> {
//                for (int i = 0; i < 100; i++) {
//                    System.out.println(Thread.currentThread().getName() + "  " + i);
//                }
//            });
//        }
        List<Future<Integer>> list = new ArrayList<>();
        for (int k = 0;k<10;k++) {
            Future<Integer> future = cacheThreadPool.submit(() -> {
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum+=i;
                }
                return sum;
            });
            list.add(future);
        }
        for(Future future: list){
            System.out.println(future.get());
        }
        //关闭线程池
        cacheThreadPool.shutdown();
    }
}


