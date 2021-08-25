package com.base;

/**
 * @author Faster
 * @date 2019/9/4 22:19
 */
public abstract class AbstractTest {
    private void fun1(){
        final String []s1 = {"1","2"};
        s1[1] = "11";
    }

    public abstract void fun2();
}
