package com.exception;

/**
 * 1.当finally块第一行代码发生了异常，就不会执行finally块
 * 2.当try、catch中有return 语句 finally 块会在return之前执行
 *
 */
public class TryFinally {

    public static int exc(){
        try{
            System.out.println("try");
            return 2;
        }catch (Exception e){
            System.out.println(e.toString());
        }finally{
            System.out.println("finally");
            return 3;
        }
    }

    public static void main(String[] args) {
//        try {
//            System.out.println("执行了try代码块");
//            int a = 2/0;
//            return ;
//        }catch (Exception e){
//            System.out.println("catch到了异常，马上进行return");
//            return ;
//        }finally {
////            int a = 2/0;
//            System.out.println("进入finally块");
//            System.out.println("finally 第一句发生了异常");
//        }
        System.out.println(exc());

    }
}
