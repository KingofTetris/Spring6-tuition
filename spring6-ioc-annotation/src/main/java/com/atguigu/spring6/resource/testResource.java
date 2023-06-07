package com.atguigu.spring6.resource;


import com.atguigu.spring6.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public class testResource {

    @Test
    public void test(){
       ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController bean = context.getBean(UserController.class);
        bean.addUser();
    }

}
