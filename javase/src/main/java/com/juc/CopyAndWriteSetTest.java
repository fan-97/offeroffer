package com.juc;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author fanjie
 * @date 2021/9/1 13:48
 */
public class CopyAndWriteSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new CopyOnWriteArraySet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(1));
    }
}
