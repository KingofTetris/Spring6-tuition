package com.atguigu.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author by KingOfTetris
 * @date 2023/5/24
 */
public class testUser {


    private Logger logger = LoggerFactory.getLogger(testUser.class);

    @Test
    public void testUserObject(){
        //加载Spring配置文件，对象创建
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        User user = (User) context.getBean("user");
        //对象使用方法
        user.add();

        //手动利用logger写入日志
        logger.info("########## 执行调用成功了........");
    }

    @Test
    public void test(){

    }
}
