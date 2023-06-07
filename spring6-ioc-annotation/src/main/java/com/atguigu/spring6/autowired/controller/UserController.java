package com.atguigu.spring6.autowired.controller;

import com.atguigu.spring6.autowired.dao.UserDao;
import com.atguigu.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */

@Controller //你要注入之前，是不是得先有个对象 <bean id="xxx" class=".....">
public class UserController {


    //1.属性注入
    //其实就是自动装配，那当然就要先有这个属性才能setter
    //注解其实也是setter，不过不用再显示地去写setter
//    @Autowired 根据/*****类型******/找到对应的对象完成注入
    //如果接口有多个实现类就不能单纯只用一个Autowired，因为根据类型ByType是没法匹配的
    //这时候就要配合ByName @Qualifier
    @Autowired
    private UserService userService;

    //2.set方法注入 显示地写出set方法,在set方法上加上注解autowired
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

//    3.构造方法注入
//    private UserService userService;
//
//    @Autowired //不过这次是在构造方法上加上Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //4.形参注入
//    private UserService userService;
//    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }

    //5.只有一个有参构造函数，注解可以省略。注意不能加上无参。
//    private UserService userService;
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }


    public void addUser(){
        System.out.println("controller方法执行了");
        userService.addUserService();
    }
}
