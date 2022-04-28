package com.container;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Faster
 * @date 2019/9/15 21:31
 */
public class HashMapLoop {
    static final Map<Integer, Integer> map = new HashMap<Integer, Integer>(2, 0.75f);

    public static void main(String[] args) throws InterruptedException {

        map.put(5, 55);

        new Thread("Thread1") {
            public void run() {
                map.put(7, 77);
                System.out.println(map);
            };
        }.start();

        new Thread("Thread2") {
            public void run() {
                map.put(3, 33);
                System.out.println(map);
            };
        }.start();

    }
}
