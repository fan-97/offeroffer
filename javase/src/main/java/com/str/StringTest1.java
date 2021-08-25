package com.str;

import java.util.StringTokenizer;

public class StringTest1 {
    private final String str ;
    private int i;

    public StringTest1(int i,String str) {
        this.i = i;
        this.str = str;

    }

    @Override
    public String toString() {
        return "StringTest1{" +
                "str='" + str + '\'' +
                ", i=" + i +
                '}';
    }

    public static void main(String[] args) {
//        StringTest1 st = new StringTest1(10,"12312");
//        System.out.println(st.toString());
//        String ss = "abcdefg";
//        System.out.println(ss.substring(1, 3));
//        // 1.new String("");
//        String s1 = new String("abc");
//        //↑ 首先在堆中创建一个 abc 的对象  然后再检查string池中有无abc这个串
//        //↑ 如果有 则直接引用指向它；如果没有 则在池中创建一个 "abc"串 然后指向它
//        //↑ 在栈里面的变量s1 使它指向 堆中的 abc对象
//        String s2 = new String("abc");
//        //↑ 创建了一个对象  new String()  因为"abc"在常量池已经存在，所以直接复制地址引用
//        //↑  s1,s2 存放在栈中
//        System.out.println(s1 == s2);//因为s1 s2  new String()时候创建的是两个不同的对象，所以引用地址不一样
//        System.out.println(s1.equals(s2));//值相同

        // 2. 字符串常量池
        String s3 = "abc";
        String s4 = "abc";
//        System.out.println("s3==s4  " + (s3 == s4));//都存放在常量池中，所以引用地址相同
//        System.out.println("s1==s3  " + (s1 == s3));//引用地址不一样，只是值相同


        String s5 = s3 + s4;
        String s6 = "abc"+"abc";
        System.out.println(s5==s6);
        StringTokenizer st = new StringTokenizer("Hello World,aaa,bbb,,dddd");
        while (st.hasMoreElements()) {
            System.out.println(st.nextToken());
        }

        String ss = "abc";
        ss.replaceAll("a","");
        System.out.println(ss);

    }

}
