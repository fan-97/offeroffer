package com.exception;

public class ExceptionTest1 {
    public static void main(String[] args) {
        try {
            int a = 2 / 0;
        } catch (ArithmeticException e){
            System.out.println("子类异常方法");
        } catch (Exception e){
            System.out.println("父类异常方法");
        }
    }
}

