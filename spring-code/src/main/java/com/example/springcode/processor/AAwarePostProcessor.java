package com.example.springcode.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author fanjie
 * @date 2022/12/21 17:13
 */
@Component
public class AAwarePostProcessor implements InstantiationAwareBeanPostProcessor {

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("[aware] before bean initialization bean:" + bean);
//        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
//    }
//
//    @Override
//    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        System.out.println("[aware] before bean initialization bean:" + beanClass);
//        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
//    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//        System.out.println("[aware] before bean initialization bean:" + bean);
        if("aservice".equals(beanName)){
            return false;
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("[aware] after bean initialization bean:" + bean);
//        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
//    }
}
