package com.atguigu.spring6.iocxml;

import com.atguigu.spring6.iocxml.bean.PersonDaoImpl;
import com.atguigu.spring6.iocxml.bean.UserDao;
import com.atguigu.spring6.iocxml.bean.UserDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author by KingOfTetris
 * @date 2023/5/24
 */
public class testUser {

    @Test
    public void test() {
        //从配置文件读取配置 别忘了文件名
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user1 = (User) context.getBean("user");
        User user2 = context.getBean(User.class);
        User user3 = context.getBean("user", User.class);
    }
    
    @Test
    public void test2(){
        //如果你的类对应多个对象，那就得加上唯一的ID来对应，不然就会报错
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        UserDaoImpl userDaoImpl = (UserDaoImpl) context.getBean("userDaoImpl");
        UserDaoImpl userDaoImpl = (UserDaoImpl) context.getBean("userDaoImpl",UserDao.class);
        userDaoImpl.run();

        PersonDaoImpl personDao = (PersonDaoImpl) context.getBean("personDaoImpl",UserDao.class);
        personDao.run();
    }
}
