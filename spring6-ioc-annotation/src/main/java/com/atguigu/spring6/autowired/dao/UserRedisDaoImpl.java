package com.atguigu.spring6.autowired.dao;

import org.springframework.stereotype.Repository;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */

@Repository
public class UserRedisDaoImpl implements UserDao {
    @Override
    public void addUserDao() {
        System.out.println("UserRedisDaoImpl里面的方法addUserDao执行了......");
    }

    @Override
    public void updateUserDao() {
        System.out.println("updateUserDao......");
    }
}
