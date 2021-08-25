package com.base;

/**
 * 演示方法的重载
 * 1.方法名必须相同
 * 2.返回值可以相同也可以不同
 * 总结：方法的重载 是指 方法名相同 参数个数、参数类型、参数顺序不同，返回值和修饰符可以相同也可以不相同
 */
public class OverrideTest {

    public static void main(String[] args) {
        int a = 37;
        int b = 4;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a+"....."+b);
    }

    //1.参数个数不同
    public void fun(int a) {
    }

    public int fun() {
        return 1;
    }

    //2.参数类型不同
    public void fun2(double a) {
    }

    public void fun2(int a) {
    }

    //3.参数顺序不同

    public void fun3(int a, double b) {
    }

    public void fun3(double a, int b) {
    }

    ;
}
