package com.juc;

import java.util.concurrent.*;

/**
 * 等待一个线程在规定时间执行任务，超时结束执行
 *
 * @author fanjie
 * @date 2022/12/8 13:41
 */
public class ThreadTimeoutTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Boolean> future = executor.submit(new Task());
        try {
            Boolean result = future.get(2, TimeUnit.SECONDS);
            System.out.println("result:" + result);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("interrupted ");
        } catch (TimeoutException e) {
            System.out.println("time out");
            future.cancel(true);
        } finally {
            executor.shutdownNow();
        }
    }

    static class Task implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }
}

