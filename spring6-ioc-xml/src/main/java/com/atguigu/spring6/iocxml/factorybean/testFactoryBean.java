package com.atguigu.spring6.iocxml.factorybean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public class testFactoryBean {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factorybean.xml");
        Object user = context.getBean("user");
        System.out.println(user);
    }
}
