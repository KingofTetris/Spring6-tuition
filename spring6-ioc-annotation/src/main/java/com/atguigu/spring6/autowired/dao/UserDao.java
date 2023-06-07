package com.atguigu.spring6.autowired.dao;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public interface UserDao {

    /**
     * 接口的方法前面都有默认的修饰符public abstract所以不能被实例化。
     */
    void addUserDao();

    void updateUserDao();
}
