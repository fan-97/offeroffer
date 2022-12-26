package com.spring;

import com.spring.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Demo1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        Date d = new Date();
        System.out.println(d.hashCode());
        System.out.println(d.clone() == d);
    }

    public static void reOrderArray(int [] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j] %2 == 0 && array[j+1] %2 ==1){
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
        for(int a:array){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
