package com.atguigu.spring6.tx;

import com.atguigu.spring6.tx.config.SpringConfig;
import com.atguigu.spring6.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */

//@SpringJUnitConfig
public class testTxAllAnnotation {
//    @Autowired
//    private BookController bookController;
    @Test
    public void test(){

        //从配置类获得context 是用new AnnotationConfigApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = context.getBean("bookController", BookController.class);
        Map<Integer,Integer> items = new HashMap<>();
        items.put(1,200);
        items.put(2,200);
        bookController.buyBooks(items,2);
    }

}
