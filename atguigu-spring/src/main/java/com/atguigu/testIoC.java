package com.atguigu;

import com.atguigu.bean.AnnotationApplicationContext;
import com.atguigu.bean.ApplicationContext;
import com.atguigu.service.UserService;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public class testIoC {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationApplicationContext("com.atguigu");
        //终于实现了手写IoC
        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
