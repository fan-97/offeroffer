package com.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Arrays工具类的常用方法练习
 */
public class ArraysExercise {
    /**
     * 排序 : sort()
     * 查找 : binarySearch()
     * 比较: equals()
     * 填充 : fill()
     * 转列表: asList()
     * 转字符串 : toString()
     * 复制: copyOf()
     */
    public static void main(String[] args) {

        System.out.println("*************排序****************");
        // *******************排序***********************
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("原始数组为：");
        print(arr);

        // Arrays.sort(int []arr)  按照自然顺序的升序进行排序
        Arrays.sort(arr);
        System.out.println("Arrays.sort(arr)");
        print(arr);

        // Arrays.sort(int []arr , int fromIndex,int toIndex)  按照升序排序 从fromIndex --- toIndex-1的那一部分数据
        int [] arr2 = {20,10,309,-129,23};
        System.out.println("原始数组");
        print(arr2);
        Arrays.sort(arr2,2,arr2.length);
        System.out.println("Arrays.sort(arr2,2,arr2.length);");
        print(arr2);

        int arr3[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
        System.out.println("原始数组");
        print(arr3);
        // parallelSort(int[] a) 按照数字顺序排列指定的数组(并行的)。同sort方法一样也有按范围的排序
        Arrays.parallelSort(arr3);
        System.out.println("Arrays.parallelSort(arr3)");
        print(arr3);

        System.out.println("*************查找****************");
        //***************查找 binarySearch()******************
        int[]  arr4 = { 10,20,0,-29,34 };
        System.out.println("原始数组");
        // 排序后再进行二分查找，否则找不到
        Arrays.sort(arr4);
        System.out.println("Arrays.binarySearch(arr4,20)");
        int s = Arrays.binarySearch(arr4, 20);
        System.out.println("20在数组的位置：" + s);


        System.out.println("*************比较****************");
        //***************比较 equals()*********************
        int[] arr5 = { 10,20,0,-29,34 };
        /*
         * 元素数量相同，并且相同位置的元素相同。 另外，如果两个数组引用都是null，则它们被认为是相等的 。
         */
        // 输出true
        System.out.println("Arrays.equals(arr4, arr5):" + Arrays.equals(arr4, arr5));


        System.out.println("*************填充****************");
        // *************填充fill(批量初始化)****************
        int[] arr6 = { 1, 2, 3, 3, 3, 3, 6, 6, 6 };
        System.out.println("原始数组");
        print(arr6);
        // 数组中所有元素重新分配值
        Arrays.fill(arr6, 3);
        System.out.println("Arrays.fill(arr6, 3)：");
        // 输出结果：333333333
        print(arr6);

        int[] arr7 = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
        System.out.println("原始数组");
        print(arr7);
        // 数组中指定范围元素重新分配值
        Arrays.fill(arr7, 0, 2, 9);
        System.out.println("Arrays.fill(arr7, 0, 2, 9);：");
        // 输出结果：993333666
        print(arr7);

        System.out.println("*************转列表****************");
        // *************转列表 asList()****************
        /*
         * 返回由指定数组支持的固定大小的列表。
         * （将返回的列表更改为“写入数组”。）该方法作为基于数组和基于集合的API之间的桥梁，与Collection.toArray()相结合 。
         * 返回的列表是可序列化的，并实现RandomAccess 。
         * 此方法还提供了一种方便的方式来创建一个初始化为包含几个元素的固定大小的列表如下：
         */
        List<String> stooges = Arrays.asList("Hello", "World", "Say Hi");
        System.out.println(stooges);


        System.out.println("*************转字符串****************");
        // *************转字符串 toString()****************
        /*
         * 返回指定数组的内容的字符串表示形式。
         */
        char[] k = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        System.out.println(Arrays.toString(k));// [a, f, b, c, e, A, C, B]


        System.out.println("*************复制****************");
        // *************复制 copy****************
        // copyOf 方法实现数组复制,h为数组，6为复制的长度
        int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
        int i[] = Arrays.copyOf(h, 6);
        System.out.println("Arrays.copyOf(h, 6);：");
        // 输出结果：123333
        print(i);

        // copyOfRange将指定数组的指定范围复制到新数组中
        int j[] = Arrays.copyOfRange(h, 6, 11);
        System.out.println("Arrays.copyOfRange(h, 6, 11)：");
        // 输出结果66600(h数组只有9个元素这里是从索引6到索引11复制所以不足的就为0)
      print(j);


    }

    public static void print(int arr[]) {
        for (int i : arr) {
            System.out.print(i + "  ");
        }

        System.out.println();
    }
}
