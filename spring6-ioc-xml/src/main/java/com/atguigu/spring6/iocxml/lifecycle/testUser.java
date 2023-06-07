package com.atguigu.spring6.iocxml.lifecycle;

import com.atguigu.spring6.iocxml.bean.PersonDaoImpl;
import com.atguigu.spring6.iocxml.bean.UserDao;
import com.atguigu.spring6.iocxml.bean.UserDaoImpl;
import org.junit.jupiter.api.Test;
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
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
        User user = context.getBean("user", User.class);
        System.out.println("6 bean对象创建完成，可以使用了");
//        System.out.println(user);
        context.close();//手动调用销毁ioc容器。要用ClassPathXmlApplicationContext实现类来new，ApplicationContext这个接口没有close方法
    }

}
