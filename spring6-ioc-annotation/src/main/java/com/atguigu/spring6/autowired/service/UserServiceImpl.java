package com.atguigu.spring6.autowired.service;


import com.atguigu.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */

@Service
public class UserServiceImpl implements UserService{

    //1.属性注入
//    @Autowired
//    private UserDao userDao;


    //2.set注入
//
//    private UserDao userDao;
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //3.构造方法注入
//    private UserDao userDao;
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //4.形参注入
//    private UserDao userDao;
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }
    //5.只有一个有参构造
//    private UserDao userDao;
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }


    //6.多个实现类，加上Qualifier(ByName)，注意首字母小写。
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void addUserService() {
        System.out.println("UserService里面的方法addUserServic执行了......");
        userDao.addUserDao();
    }
}
