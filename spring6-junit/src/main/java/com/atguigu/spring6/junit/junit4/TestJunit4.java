package com.atguigu.spring6.junit.junit4;

import com.atguigu.spring6.junit.junit5.User;
import org.junit.Test;//Junit4 是这个包
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */


@RunWith(SpringJUnit4ClassRunner.class)//Junit4独有的注解
@ContextConfiguration("classpath:bean.xml")
public class TestJunit4 {

    @Autowired
    private User user;

    @Test
    public void test(){
        System.out.println(user);
        user.run();
    }
}
