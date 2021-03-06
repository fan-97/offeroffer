package com.threadd;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fanjie
 * @date 2021/8/31 20:02
 */
public class ThreadPoolTest {
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    private static final int RUNNING    = -1 << COUNT_BITS;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Integer.toBinaryString(-1));
        ThreadPoolTest test = new ThreadPoolTest();
        System.out.println(runStateOf(test.ctl.get()));
        System.out.println(workerCountOf(test.ctl.get()));
        final ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        executor.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
        executor.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });

    }

    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }
}
