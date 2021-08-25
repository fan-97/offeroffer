package com.onlinetest;

/**
 * @author Faster
 * @date 2019/9/9 16:36
 */
public class zhiguankeji0909 {

    public static void main(String[] args) {
        B b = new B();
        b.print();
    }

}

class A {
    public A() {
        System.out.println("I'm A");
    }

    public void print() {
        System.out.println("Hello A");
    }

    static {
        System.out.println("static A");
    }
}

class B extends  A{
    public B(){
        System.out.println("I'm B");
    }

    public void print(){
        System.out.println("Hello B");
    }

    static {
        System.out.println("static B");
    }

}
