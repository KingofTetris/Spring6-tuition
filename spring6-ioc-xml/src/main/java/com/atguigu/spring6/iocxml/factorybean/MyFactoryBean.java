package com.atguigu.spring6.iocxml.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */

//虽然配置的是MyFactoryBean
    //但是其实返回的是getObject()返回的对象
    //利用FactoryBean这个特性，Spring才能很好地整合第三方框架
    //比如整合Mybatis时，Spring就是通过FactoryBean机制来帮我们创建SqlSessionFactory对象。
    //这样做使得程序员并不需要关心复杂组件的详细创建过程。
public class MyFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
