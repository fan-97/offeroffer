package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Faster
 * @date 2019/9/11 15:19
 */
public class ReflectTest01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        A a = new C();
        a.f();
        System.out.println(a.getClass().getName());
        invokeMethod(a,"w");
        invokeMethod(a,"x");
        invokeMethod(a,"y");
        invokeMethod(a,"g");

        Class clazz = Class.forName("com.reflect.B");
        Constructor constructor = clazz.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        B b = (B) constructor.newInstance();
        b.print();
    }

    public static void invokeMethod(Object obj, String methodName) {
        Class clazz = obj.getClass();
        try {
            Method method = clazz.getDeclaredMethod(methodName);
            method.setAccessible(true);
            method.invoke(obj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class B{
    private B(){}
    public void print(){
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBB1");
    }
}

interface A {
    void f();
}

class C implements A {

    @Override
    public void f() {
        System.out.println("public f()");
    }

    public void g() {
        System.out.println("public g()");
    }

    protected void w() {
        System.out.println("protected w()");
    }

    private void x() {
        System.out.println("private x()");
    }

    void y() {
        System.out.println("default y()");
    }
}
