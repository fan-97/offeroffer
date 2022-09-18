package com.container;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Faster
 * @date 2019/9/7 16:45
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(3);
        map.put("1",1);
        map.put("1",2);
//        for (int i = 0; i < 13; i++) {
//            map.put("i" + i, i);
//        }

        //获取所有的key  keySet()
        System.out.println("=====================keySet()方式==================");
        for (String s : map.keySet()) {
            System.out.println(s + "...." + map.get(s));
        }

        //获取所有的value
        System.out.println("=====================values()方式==================");
        for (Integer i : map.values()) {
            System.out.println("value  " + i);
        }

        //foreach entrySet
        System.out.println("=====================foreach entrySet==================");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "...." + entry.getValue());
        }
        System.out.println("=====================1.8新特性 lambda==================");

        map.forEach((key, value) -> {
            System.out.println(key + "...." + value);
        });
    }

    public static int mod1(int n, int d) {
        return n % d;
    }

    public static int mod2(int n, int d) {
        return n & (d - 1);
    }
}
