package com.algorithm;

import org.apache.commons.lang3.StringUtils;

/**
 * 异或技巧:
 * 1.不用额外的变量交换两个变量的值
 * 2.一个数组中有一个数X出现的次数是奇数次，其他的数出现偶数次，找出这个数X
 * 3.一个数组中有两个数X，Y出现的次数是奇数次，其他的数出现偶数次，找出这个数X，Y
 *
 * @author fanjie
 * @date 2022/8/16 11:39
 */
public class ExclusiveOr {
    public static void main(String[] args) {
        solution1(12, 24);
        solution2(new Integer[]{1, 1, 2, 2, 3, 3, 5, 5, 5});
        solution3(new Integer[]{1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5});
    }

    /**
     * 不用额外的变量交换两个数字
     *
     * @param a
     * @param b
     */
    private static void solution1(int a, int b) {
        System.out.printf("before:a=%s,b=%s%n", a, b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.printf("after:a=%s,b=%s%n", a, b);
    }

    /**
     * 找出数组中出现奇数次的一个数字
     *
     * @param arr 有一个数出现的次数为奇数次，其他的数为偶数次
     */
    private static void solution2(Integer[] arr) {
        int eor = 0;
        for (Integer i : arr) {
            eor ^= i;
        }
        System.out.printf("[%s]中出现次数为奇数次的数为[%s]%n", StringUtils.join(arr, ","), eor);
    }

    private static void solution3(Integer[] arr) {
        int eor = 0;
        for (Integer integer : arr) {
            eor ^= integer;
        }
        int index = indexLowerOne(eor);
        if (index == -1) {
            System.out.println("没有出现次数为奇数的两个数");
            return;
        }
        int eor1 = 0;
        for (Integer i : arr) {
            if (isOne(i, index)) {
                eor1 ^= i;
            }
        }
        System.out.printf("[%s]中出现次数为奇数次的两个数分别为:num1:%s  num2:%s%n", StringUtils.join(arr, ","), eor1, eor ^ eor1);
    }

    /**
     * 返回最低位的是1的位置
     *
     * @param num
     * @return 当返回-1的时候表示 每一个二进制位都是0
     */
    private static int indexLowerOne(int num) {
        if (num == 0) {
            return -1;
        }
        int index = 0;
        while ((num & 1) == 0) {
            num >>= 1;
            index++;
        }
        return index;
    }

    /**
     * 判断index位置上的二进制是否为1
     *
     * @param num
     * @param index
     * @return
     */
    private static boolean isOne(int num, int index) {
        return ((num >> index) & 1) == 1;
    }
}
