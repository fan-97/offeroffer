package com.collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListTest implements Serializable {
    transient static int a;

    public static void main(String[] args) {
       /*  List<Integer> L1 = new ArrayList<>();
        L1.add(1);
        L1.add(2);
       L1.add(3);
        L1.add(4);
        //遍历集合：
        //1.for循环
        System.out.println("----for loop------");
        for(int i=0;i<L1.size();i++){
            System.out.print(L1.get(i));
        }
        System.out.println();
        System.out.println("-----foreach------");
        //2.增强型for jdk8++
        for(Integer i : L1){
            System.out.print(i);
        }
        System.out.println();
        System.out.println("------Iterator-----");
        //3.Iterator
        Iterator<Integer> it = L1.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }*/
        //system_arrayCopy();
        // array_copy();
        //ensureCapacityTest();
//        System.out.println(solution(100));

//        cloneTest();
        ArrayList<String> lit1 = new ArrayList<>();
        lit1.add(null);
//        for (int i = 0; i < 5; i++) {
//            lit1.add("" + i);
//        }
//        for(String s:lit1){
//            System.out.println(s);
//        }
        LinkedList<String> linkedList = new LinkedList(lit1);
        linkedList.add(null);

    }
//
//
//    public static void system_arrayCopy() {
//        int[] a = {1, 2, 3};
//        int[] b = {2, 3, 4};
//        System.arraycopy(a, 0, b, 1, 2);
//        for (int i = 0; i < 3; i++) {
//            System.out.println(b[i]);
//        }
//    }
//
//    public static void array_copy() {
//        int[] a = {1, 2, 3};
//        a = Arrays.copyOf(a, 10);
//        System.out.println("a.length:" + a.length);
//        for (int i : a) {
//            System.out.println(i);
//        }
//
//    }
//
//    //测试用户主动给list扩容
//    public static void ensureCapacityTest() {
//
//        long startTime = System.currentTimeMillis();
//        int N = 10000000;
//        ArrayList<Object> list = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            list.add(i);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("没有调用ensureCapacity时间：" + (endTime - startTime));
//
//        startTime = System.currentTimeMillis();
//        list = new ArrayList<>();
//        list.ensureCapacity(N + 1);
//        for (int i = 0; i < N; i++) {
//            list.add(i);
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("调用ensureCapacity时间：" + (endTime - startTime));
//
//    }
//
//    public static int solution(int n){
//
//        String s = "123";
//        System.out.println(s.hashCode());
////        boolean b = (n>0)&&(n += solution(n-1))!=0;
//        return n;
//    }

//
//    private static void cloneTest(){
//        ArrayList<String> lit1 = new ArrayList<>();
//        for(int i=0;i<5;i++){
//            lit1.add(""+i);
//        }
//        for(String s:lit1){
//            System.out.println(s);
//        }
//    }

}
