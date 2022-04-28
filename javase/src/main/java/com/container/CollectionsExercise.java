package com.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections 工具类常用方法：
 * 1.排序
 * 2.查找、替换
 * 3.同步控制（不推荐）
 */
public class CollectionsExercise {
    public static void main(String[] args) {
        //collection_sor();
        findAndReplace();
    }

    /**
     * 一：排序
     * 1.void reverse(List list)
     * 2.void shuffle (List list)
     * 3.void sort(List list)
     * 4.void sort(List list,Comparator c)
     * 5.void swap(List list,int i,int j)
     * 6.void rotate (List list,int distance)
     */
    public static void collection_sor() {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(30);
        list.add(10);
        list.add(6);
        list.add(89);
        list.add(-10);
        //1.void reverse(List list) 反转集合
        System.out.println("反转集合前：" + list);
        Collections.reverse(list);
        System.out.println("反转集合后：" + list);
        //2.void shuffle (List list) 随机排序
        System.out.println("随机排序前：" + list);
        Collections.shuffle(list);
        System.out.println("随机排序后：" + list);
        //3.void sort(List list) 按照自然顺序的升序排序
        System.out.println("按照自然顺序升序排序前："+ list);
        Collections.sort(list);
        System.out.println("按照自然顺序升序排序后："+ list);
        //4.void sort(List list,Comparator c)  按照Comparator 的逻辑进行排序
        System.out.println("自定义排序前（降序）：" + list);
        Collections.sort(list,(Integer o1,Integer o2)->o2-o1);
        System.out.println("自定义排序后（降序）：" + list);
        //5.void swap(List list,int i,int j) 交换索引 i  j  元素的位置
        System.out.println("交换前（0 和 4交换）：" + list);
        Collections.swap(list,0,4);
        System.out.println("交换后（0 和 4交换）：" + list);
        //6.void rotate (List list,int distance)旋转。当distance为正数时，将List后distance个元素移到前面。当distance为负数时，将 list的前distance个元素整体移到后面。
        System.out.println("旋转前:"+list);
        Collections.rotate(list,3);
        System.out.println("旋转后:"+list);

    }

    /**
     * 二：替换和查找
     * 1.int binarySearch(List list,Object key) 对List进行二分查找，返回索引。list必须是有序的
     * 2.int max(Collection coll) 根据元素的自然顺序，返回最大的元素。
     * 3.int max(Collection coll,Comparator c) 根据自定义排序，返回最大的元素。
     * 4.int min(Collection coll) 根据元素的自然顺序，返回最小的元素。
     * 5.int min(Collection coll,Comparator c) 根据自定义排序，返回最小的元素。
     * 6.void fill(List list,Object key) 用指定元素，代替list中所有的元素
     * 7.int frequency(Collection c ,Object o) 统计元素出现的次数
     * 8.int indexOfSubList(List list,List target) 统计target在list中第一次出现的索引，找不到则返回-1，类比int lastIndexOfSubList(List source, list target).
     * 9.int lastIndexOfSubList(List list,List target) 统计target在list中最后一次出现的索引，找不到则返回-1
     * 10.boolean replaceAll(List list, Object oldVal, Object newVal) 用新元素替换旧元素
     */
    public static void findAndReplace(){
        ArrayList <Integer> list1 = new ArrayList<>();
        list1.add(20);
        list1.add(30);
        list1.add(20);
        list1.add(6);
        list1.add(89);
        list1.add(-10);


        ArrayList <Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(89);

        System.out.println("原始集合 list1： "+ list1);
        System.out.println("原始集合 list2： "+ list2);

        System.out.println("Collections.max(list1):   " + Collections.max(list1));

        System.out.println("Collections.max(list1,c)    " + Collections.max(list1,(o1,o2)->o2-o1));

        System.out.println("Collections.min(coll)  "+ Collections.min(list1));

        System.out.println("Collections.min(coll，c)  "+ Collections.min(list1,(o1,o2)->o2-o1));

        System.out.println("统计20出现的次数：  "+ Collections.frequency(list1,20));

        System.out.println("Collections.indexOfSubList(list1,list2)   "  + Collections.indexOfSubList(list1,list2));

        System.out.println("Collections.lastIndexOfSubList(list1,list2)   "  + Collections.lastIndexOfSubList(list1,list2));

        //int binarySearch(List list,Object key)
        Collections.sort(list1);
        System.out.println("元素 20 在list1 中的索引位置为："+ Collections.binarySearch(list1,20));


        System.out.println("将list2中元素全部替换成 0   " );
        Collections.fill(list2,0);
        System.out.println("替换后的list2" + list2);

        //将list1中的20替换成-20
        System.out.println("Collections .replaceAll()" + Collections.replaceAll(list1,20,-20));
        System.out.println("替换后的list1" + list1);
    }
}
