package com.atguigu.service.impl;

import com.atguigu.anno.Bean;
import com.atguigu.anno.DI;
import com.atguigu.dao.UserDao;
import com.atguigu.service.UserService;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */

@Bean
public class UserServiceImpl implements UserService {

    @DI
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service....");
        //调用dao的方法
        userDao.add();
    }
}
