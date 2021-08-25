package com.threadd;

/**
 * @author Faster
 * @date 2019/9/2 18:25
 */
public class CAS01 {


    public static void print(){
        System.out.println("打印对象");
    }

    public static void main(String[] args) {
//        AtomicInteger atomicInteger = new AtomicInteger(100);
        //线程1  对原数进行 -50操作
        //线程2  进行-50操作
        //线程3  进行+50操作
        ((CAS01)null).print();

    }
}
