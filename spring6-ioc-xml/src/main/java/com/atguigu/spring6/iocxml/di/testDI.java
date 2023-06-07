package com.atguigu.spring6.iocxml.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author by KingOfTetris
 * @date 2023/5/24
 */
public class testDI {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book1 = context.getBean("book1",Book.class);
        System.out.println(book1);
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = context.getBean("book2",Book.class);
        System.out.println(book);
    }
}
