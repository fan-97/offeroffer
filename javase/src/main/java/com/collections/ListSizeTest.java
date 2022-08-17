package com.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试ArrayList和LinkedList谁占用的空间更大
 *
 * @author fanjie
 * @date 2021/8/31 9:13
 */
public class ListSizeTest {
    private static final int MAX_SIZE = 100000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        new Thread(() -> {
            for (int i = 0; i < MAX_SIZE; i++) {
                arrayList.add(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < MAX_SIZE; i++) {
                linkedList.add(i);
            }
        }).start();
    }
}
