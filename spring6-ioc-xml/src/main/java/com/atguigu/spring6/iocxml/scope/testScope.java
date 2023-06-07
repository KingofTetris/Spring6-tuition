package com.atguigu.spring6.iocxml.scope;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public class testScope {

    @Test
    public void test(){

        //如果作用域scope="prototype"，那么每次获取就会实例化一次
        //如果是默认的singleton，那么每次获取都是同一份。
        //就是懒汉式:什么时候需要什么时候取实例
        // 饿汉式:IOC加载的时候就创建实例
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders scope = context.getBean("orders", Orders.class);
        System.out.println(scope);
        Orders scope2 = context.getBean("orders", Orders.class);
        System.out.println(scope2);
        System.out.println(scope == scope2);
    }
}
