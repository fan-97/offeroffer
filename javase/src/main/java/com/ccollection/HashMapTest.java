package com.ccollection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Faster
 * @date 2019/9/7 16:45
 */
public class HashMapTest {
    public static void main(String[] args) {
        System.out.println(mod1(10, 3));
        System.out.println(mod2(10, 3));
        HashMap<String, Integer> map = new HashMap<>(2);
        map.put("zhangsan01", 23);
        map.put("zhangsan02", 22);
        map.put("zhangsan03", 33);

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
        return (n - 1) & d;
    }
}
