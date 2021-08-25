package com.ccollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Map<String,String> map = new HashMap<>();
        map.put("zhangsan","12");
        map.put("zhangsan","123");
        System.out.println(map.get("zhangsan"));
        int n = 4;
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int h  = "hh".hashCode();
        System.out.println(h);
    }
}
