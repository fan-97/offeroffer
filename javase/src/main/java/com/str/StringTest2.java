package com.str;

/**
 * @author Faster
 * @date 2019/9/2 10:11
 */
public class StringTest2 {
    public static void main(String[] args) {
//        String s1 = new String("aaa");
//        String s2 = "aaa";
//        System.out.println(s1 == s2);    // false

//        String s1 = new String("bbb").intern();
//        String s2 = "bbb";
//        System.out.println(s1 == s2);    // true
//
//        s1 = "ccc";
//        s2 = "ccc";
//        System.out.println(s1 == s2);    // true
//
//        String s1 = new String("ddd").intern();
//        String s2 = new String("ddd");
//        System.out.println(s1 == s2);    // true
//
//        s1 = "ab" + "cd";
//        s2 = "abcd";
//        System.out.println(s1 == s2);    // true
//
//        String temp = "hh";
//        s1 = "a" + temp;
//// 如果调用s1.intern 则最终返回true
//        s2 = "ahh";
//        System.out.println(s1 == s2);    // false
//
//        String temp = "hh".intern();
//        String s1 = "a" + temp;
//        String s2 = "ahh";
//        System.out.println(s1 == s2);    // false
//
//        String temp = "hh".intern();
//        String s1 = ("a" + temp).intern();
//        String s2 = "ahh";
//        System.out.println(s1 == s2);    // true
//
//        String s1 = new String("1");    // 同时会生成堆中的对象 以及常量池中1的对象，但是此时s1是指向堆中的对象的
//        s1.intern();            // 常量池中的已经存在
//        String   s2 = "1";
//        System.out.println(s1 == s2);    // false
//
//        String s3 = new String("1") + new String("1");    // 此时生成了四个对象 常量池中的"1" + 2个堆中的"1" + s3指向的堆中的对象（注此时常量池不会生成"11"）
//        s3.intern();    // jdk1.7之后，常量池不仅仅可以存储对象，还可以存储对象的引用，会直接将s3的地址存储在常量池
//        String s4 = "11";    // jdk1.7之后，常量池中的地址其实就是s3的地址
//        System.out.println(s3 == s4); // jdk1.7之前false， jdk1.7之后true
//
//        s3 = new String("2") + new String("2");
//        s4 = "22";        // 常量池中不存在22，所以会新开辟一个存储22对象的常量池地址
//        s3.intern();    // 常量池22的地址和s3的地址不同
//        System.out.println(s3 == s4); // false

        // 对于什么时候会在常量池存储字符串对象，我想我们可以基本得出结论:
        // 1. 显示调用String的intern方法的时候; 2. 直接声明字符串字面常量的时候，例如: String a = "aaa";
        // 3. 字符串直接常量相加的时候，例如: String c = "aa" + "bb";
        // 其中的aa/bb只要有任何一个不是字符串字面常量形式，都不会在常量池生成"aabb". 且此时jvm做了优化，不会同时生成"aa"和"bb"在字符串常量池中
    }
}
