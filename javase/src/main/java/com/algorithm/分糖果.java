package com.algorithm;

import java.util.Scanner;

/**
 * @author Faster
 * @date 2020/3/5 17:14
 */
public class 分糖果 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        int nu = in.nextInt();
        distributeCandies(c,nu);
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int ans [] = new int[num_people];
        int per = 1;
        while(candies>0){
            for(int i=0;i<num_people&&candies>0;i++){
                if(candies>per){
                    ans[i] += per;
                    candies -= per;
                    per ++;
                }else{
                    ans [i] += candies;
                    candies = 0;
                }
            }
        }
        return ans;
    }
}
