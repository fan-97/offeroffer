package com.juc.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 阻塞队列的基础用法
 *
 * @author fanjie
 * @date 2021/9/8 10:48
 */
public class BlockingQueueBaseUse {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
//        put(queue);
//        add(queue);
        offer(queue);
    }

    /**
     * put的时候当队列容量达到capacity 会进行阻塞等待
     *
     * @param q
     * @throws Exception
     */
    public static void put(BlockingQueue<Integer> q) throws Exception {
        q.put(1);
        System.out.println("put(1):");
        q.put(2);
        System.out.println("put(2):");
    }

    /**
     * 当队列满的时候 直接抛出异常
     * 返回值只会是true 或者直接抛异常
     *
     * @param q
     * @throws Exception
     */
    private static void add(BlockingQueue<Integer> q) throws Exception {
        System.out.println("add(1):" + q.add(1));
        System.out.println("add(2):" + q.add(2));
    }

    /**
     * 添加失败会返回false，添加成功直接返回true
     *
     * @param q
     * @throws Exception
     */
    private static void offer(BlockingQueue<Integer> q) throws Exception {
        System.out.println("offer(1):" + q.offer(1));
        System.out.println("offer(2):" + q.offer(2));
    }

}
