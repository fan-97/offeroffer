package com.base;

import java.lang.reflect.InvocationTargetException;

public class NewObject implements  Cloneable{
    //创建对象的5种方式

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, CloneNotSupportedException {
        //1.new关键字
        NewObject obj_new = new NewObject();
        //2.CLass类的newInstance
        NewObject obj_instance = (NewObject) Class.forName("com.base.NewObject").newInstance();
        //3.Constructor类的newInstance
        NewObject obj_con_ins = (NewObject)NewObject.class.getConstructors()[0].newInstance();
        //4.clone方法
        NewObject obj_clone = (NewObject) obj_instance.clone();
        //5.反序列化


        System.out.println("obj_new == obj_instance   " + (obj_new == obj_instance));
        System.out.println("obj_instance == obj_con_ins    " + (obj_con_ins== obj_instance));
        System.out.println("obj_con_ins== obj_clone   " + (obj_clone== obj_con_ins));


        //深拷贝和浅拷贝


        //intern
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

}
