package com.atguigu.spring6.junit.junit5;

import org.junit.jupiter.api.Test;//Junit5多了一个jupiter
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */

//让测试类去读指定的配置文件
    //这里的classpath是哪里?src/main/java/resources?
@SpringJUnitConfig(locations = "classpath:bean.xml")
//下面两个注解和上面的SpringJUnitConfig注解效果一样
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")
public class testJunit5 {

    /**
     * 告诉test配置文件的位置，然后直接注入，就可以用user了，
     * 不用再重复写ApplicationContext去取对象
     */
    @Autowired //自动注入时，别忘了给要注入的对象也加上注解
    private User user;

    @Test
    public void test(){
        System.out.println(user);
        user.run();
    }
}
