package com.atguigu.spring6.iocxml.auto.controller;

import com.atguigu.spring6.iocxml.auto.service.UserService;
import com.atguigu.spring6.iocxml.auto.service.UserServiceImpl;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public class UserController {


    //自动装配，那当然就要先有这个属性才能setter
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){

        //auto自动注入实现
        System.out.println("controller方法执行了");
        userService.addUserService();
        /**
         * 没有Spring时候的做法
         * Controller->Service->Dao 一层一层调用。 Service和Dao都是用实现类来实例化接口
         */
//        //实例化实现接口的对象userService
//        UserService userService = new UserServiceImpl();
//        //userService调用对应的方法
//        userService.addUserService();


    }
}
