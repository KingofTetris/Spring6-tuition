package com.atguigu.spring6.iocxml.bean;

import com.atguigu.spring6.iocxml.User;

/**
 * @author by KingOfTetris
 * @date 2023/5/24
 */
public class PersonDaoImpl implements UserDao {
    public void run(){
        System.out.println("PersonDaoImpl run");
    }
}
