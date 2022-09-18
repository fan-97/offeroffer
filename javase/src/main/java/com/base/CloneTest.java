package com.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanjie
 * @date 2022/8/17 10:06
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Fine f1 = new Fine();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        f1.setList(list);
        f1.setName("zhangsan");
        Fine cloneF = (Fine)f1.clone();
        cloneF.getList().add("4");
        cloneF.setName("lisi");
        System.out.println(f1.getList());
        System.out.println(f1.getName());

    }

    static class Fine implements Cloneable{
        private String name;
        private List<String> list;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
