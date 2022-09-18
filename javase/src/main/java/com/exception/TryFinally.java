package com.exception;

/**
 * 1.当finally块第一行代码发生了异常，就不会执行finally块
 * 2.当try、catch中有return 语句 finally 块会在return之前执行
 */
public class TryFinally {

    public static void main(String[] args) throws Exception {
//        System.out.println(exc());
        tryFinallyNoCatch();
    }

    public static void tryFinallyNoCatch() throws Exception {
        try {
            System.out.println("before.....");
            int a = 2 / 0;
            System.out.println("after.....");
        } finally {
            System.out.println("finally.....");
        }
    }

    public static int exc() {
        try {
            System.out.println("try");
            return 2;
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("finally");
            return 3;
        }
    }
}
