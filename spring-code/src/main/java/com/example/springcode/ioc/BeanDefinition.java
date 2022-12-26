package com.example.springcode.ioc;

/**
 * 对象 定义信息
 * @author fanjie
 * @date 2022/12/22 16:23
 */
public class BeanDefinition {
    private String beanName;
    private Class beanClass;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
