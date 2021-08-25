package com.base;

import java.util.ArrayList;

public class Fudianshu {
    public static void main(String[] args) {
        double a = 2.3;
        float b = (float) 2.3;
        System.out.println(a==b);



        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        System.out.printf("Before add:arrayList.size() = %d\n",arrayList.size());

        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(9);
        System.out.printf("After add:arrayList.size() = %d\n",arrayList.size());
        Integer[] integer = arrayList.toArray(new Integer[0]);
        Integer[] integer2 = new Integer[arrayList.size()];
        integer2 = (Integer[]) arrayList.toArray();

        System.out.println(1231);
    }
}
