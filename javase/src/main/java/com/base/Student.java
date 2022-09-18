package com.base;

import java.io.Serializable;

/**
 *
 * @author fanjie
 * @date 2022/8/17 10:21
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -1037087801775294451L;
//    private static final long serialVersionUID = -103708780177529451L;
    private String name;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
