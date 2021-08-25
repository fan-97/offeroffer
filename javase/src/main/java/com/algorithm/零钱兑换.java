package com.algorithm;

import java.util.Arrays;

/**
 * 代码未修改！！！！
 * 思路：贪心+回溯  从硬币面值最大开始枚举所有的可能兑换零钱的硬币数，当兑换最多的面值大的硬币超过零钱总数，就回溯减少该面值的数量。
 * @author Faster
 * @date 2020/3/8 21:15
 */
public class 零钱兑换 {
    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int coins[] = {186,419,83,408};
        int amount = 6249;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        sol(coins,amount,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    public static void sol(int []coins,int amount,int count){
        if(amount == 0) {
            ans = Math.min(count, ans);
            return ;
        }
        for(int i=coins.length-1;i>=0;i--){
            if(amount >= coins[i]){
                int c = amount/coins[i];
                sol(coins,amount-c*coins[i],count+c);
            }
        }

    }
}
