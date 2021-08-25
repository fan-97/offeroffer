package com.juc.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 演示线程池阻塞队列满了之后继续提交任务的现象
 *
 * @author fanjie
 * @date 2021/6/24 21:14
 */
public class ThreadPoolTest1 {

    private static final TimeUnit unit = TimeUnit.SECONDS;
    private static final BlockingQueue workQueue = new LinkedBlockingDeque();
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR =
            new ThreadPoolExecutor(1, 1, 10, unit, workQueue);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            THREAD_POOL_EXECUTOR.execute(() -> {
                try {
                    Thread.sleep(1000);
                    if(finalI %10==0){
                        int a = 2/0;
                    }
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }

}
