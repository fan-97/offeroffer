package com.collections;

import java.util.ArrayList;
import java.util.List;

public class Main {
    int a = 1;
    protected int b = 2;

    public static void main(String[] args) {
      /*  TreeMap<Person,String> treeMap = new TreeMap<>();
        treeMap.put(new Person(10,"张三1"),"zhangsag1");
        treeMap.put(new Person(10,"张三2"),"zhangsan2");
        treeMap.put(new Person(20,"张三3"),"zhangsan3");

        for (Person key:treeMap.keySet()){
            System.out.println(key.toString());
        }*/
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new String("Str") + new String("ing");
        System.out.println(str2.intern() == str2);

        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(16);
        list.add(12);
        list.add(10);
        list.sort((o1, o2) -> {
            return o1.compareTo(o2);
        });
        System.out.println(list);

    }
}

class Person implements Comparable<Person> {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ":" + age;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

}
