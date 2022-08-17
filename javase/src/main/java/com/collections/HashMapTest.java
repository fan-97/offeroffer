package com.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Faster
 * @date 2019/9/7 16:45
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(3);
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

        A a = new A("zhangsan");
        A aa = new A("zhangsan");
        Map<A, String> aMap = new HashMap<>();
        System.out.println(a);
        System.out.println(aa);
        aMap.put(a, "a1");
        aMap.put(aa, "a2");
        System.out.println("a:"+aMap.get(a));
        System.out.println("aa:"+aMap.get(aa));

        Set<A> aList = new HashSet<>();
        aList.add(new A("1"));
        aList.add(new A("1"));
        aList.add(new A("1"));
        System.out.println(aList);

    }

    public static int mod1(int n, int d) {
        return n % d;
    }

    public static int mod2(int n, int d) {
        return n & (d - 1);
    }

    static class A {
        private String name;

        public A(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof A)) {
                return false;
            }
            A aa = (A) obj;
            return aa.name.equals(this.name);
        }

        @Override
        public String toString() {
            return "A{" +
                    "hashcode='" + hashCode() + '\'' +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
