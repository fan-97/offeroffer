package com.algorithm;

/**
 * @author Faster
 * @date 2020/3/12 21:35
 */
public class 字符串的最大公因子 {

    public static String gcdOfStrings(String str1, String str2) {
       //如果str1和str2含有最大公因子 那么，str1+str2 与str2+str1相等
        // 如果str1和str2有最大公因子，并且它们的最大公因子的长度一定为   str1和str2的长度最大公因数。并且一定是从index[0]截取 对应长度的字符串
        if(!(str1+str2).equals(str2+str1)) return "";
        return str1.substring(0,gcd(str1.length(),str2.length()));
    }

    public static int gcd(int a,int b){
        if(b!=0)
            return gcd(b,a%b);
        return a;
    }

    public static void main(String[] args) {
        System.out.println(0%1);
        System.out.println(gcdOfStrings("ABCABC","ABC"));
        int ans = gcd(0,3);
        System.out.println(ans);
    }

}
