package com.container;

import java.util.HashMap;
import java.util.Map;

/**
 * 关于hashCode和equals的处理，遵循如下规则：
 * 1） 只要覆写equals，就必须覆写hashCode。
 * 2） 因为Set存储的是不重复的对象，依据hashCode和equals进行判断，所以Set存储的对象必须覆写这两个方法。
 * 3） 如果自定义对象作为Map的键，那么必须覆写hashCode和equals。
 * 说明：String已覆写hashCode和equals方法，所以我们可以愉快地使用String对象作为key来使用。
 *
 * 如果只重写equals而不重写hashCode，则会出现以下现象：
 * 1) map中会出现重复的元素
 * 2) 无法从map中获取到value（使用new的方式创建对象作为key）
 * @author fanjie
 * @date 2022/9/18 15:12
 */
public class HashCodeAndEqualsTest {
    public static void main(String[] args) {
        Person p1 = new Person("zhangsan", 11);
        Person p2 = new Person("zhangsan", 13);

        Map<Person, Integer> map = new HashMap<>();
        map.put(p1, 1);
        map.put(p2, 2);
        map.forEach((k, v) -> {
            System.out.println("key:" + k + "  value:" + v);
        });
        System.out.println(map.get(new Person("zhangsan", 11)));
    }

    static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Person)) {
                return false;
            }
            Person p1 = (Person) obj;
            return p1.getName().equals(this.getName());
        }

//        @Override
//        public int hashCode() {
//            return Objects.hash(name, age);
//        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
