package com.container;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("zhangsan");
        set.add("lisi");
        set.iterator().forEachRemaining(System.out::println);

    }
}
