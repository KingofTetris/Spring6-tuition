package com.atguigu.spring6.iocxml.auto.dao;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void addUserDao() {
        System.out.println("UserDao里面的方法addUserDao执行了......");
    }

    @Override
    public void updateUserDao() {
        System.out.println("updateUserDao......");
    }
}
