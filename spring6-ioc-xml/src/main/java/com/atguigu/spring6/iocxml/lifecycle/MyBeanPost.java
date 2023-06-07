package com.atguigu.spring6.iocxml.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */

//让类实现接口BeanPostProcessor 变成后置处理器
public class MyBeanPost implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3 bean的前置处理器，在initMethod方法前执行");
        System.out.println(beanName +"::" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5 bean的后置处理器，在initMethod方法后执行");
        System.out.println(beanName +"::" + bean);
        return bean;
    }
}
