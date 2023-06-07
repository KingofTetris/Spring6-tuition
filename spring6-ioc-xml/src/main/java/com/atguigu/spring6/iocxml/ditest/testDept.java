package com.atguigu.spring6.iocxml.ditest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author by KingOfTetris
 * @date 2023/5/24
 */
public class testDept {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-dilist.xml");
        Dept dept = context.getBean("dept", Dept.class);
        dept.info();
    }


    /**
     * 说明其实无论是内部bean还是外部bean 都不能让ref形成闭环，否则就会StackOverflow
     */
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-dilist-internalbean.xml");
        Dept dept = context.getBean("dept", Dept.class);
        dept.info();
    }
}
