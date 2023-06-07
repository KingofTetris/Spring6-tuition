package com.atguigu.bean;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public interface ApplicationContext {
    //Spring的BeanFactory用getObject返回对象。
    //那我们也模仿
    Object getBean(Class clazz);
}
