package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Faster
 * @date 2020/3/6 10:37
 */
public class 和为s的连续正数序列 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        lists.add(list);
        list.add(3);
        list.add(4);
        lists.add(list);
        Integer [][] temp = new Integer[lists.size()][];
        for(int i=0;i<temp.length;i++){
            temp[i] = lists.get(i).toArray(new Integer[0]);
        }
        int [][]ans = new int[temp.length][];
        for(int i=0;i<temp.length;i++){
            
            for(int j=0;j<temp[i].length;j++){
                int a = ans[i][j];
                System.out.println(temp[i][j]);
            }
        }
//        int a = new Integer(1);

    }
}
