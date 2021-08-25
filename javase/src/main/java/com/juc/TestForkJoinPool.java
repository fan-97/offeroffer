package com.juc;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class TestForkJoinPool {
    public static void main(String[] args) {

        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 100000000L);

        long sum = pool.invoke(task);

        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("使用时间："+ Duration.between(start,end).toMillis());
    }

}

class ForkJoinCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= 10000L) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long mid = (start + end) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, mid);
            left.fork();
            ForkJoinCalculate right = new ForkJoinCalculate(mid + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}
