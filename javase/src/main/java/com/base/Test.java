package com.base;

import com.ccollection.Main;

/**
 * @author Faster
 * @date 2019/9/17 17:05
 */
public class Test extends Main {
    public Test(){

    }
    public static void main(String[] args) {
        A a = new A();
        change(a);
        System.out.println(a.i);
    }

    public static void change(A a){
        a.i = 20;
        A aa = new A();
        a = aa;
        System.out.println(aa.i+"  "+a.i);
    }
}

class A{
    public int i = 15;
}
