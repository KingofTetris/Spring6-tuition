package com.atguigu.spring6.resource.service;


import com.atguigu.spring6.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */

@Service("myUserService")
//注解里面什么都不写默认等于value="userServiceImpl",写上myUserService等于value="myUserService"
public class UserServiceImpl implements UserService {

    //你不指定Resource里面的名字是什么，就直接根据属性的名称来匹配
    //这里就是myUserDao
    @Resource
    private UserDao myUserDao;

    @Override
    public void addUserService() {
        System.out.println("UserService里面的方法addUserServic执行了......");
        myUserDao.addUserDao();
    }
}
