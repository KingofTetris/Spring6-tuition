package com.atguigu.spring6.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */

//@Component(value = "user") //等于<bean id = "user",class="com.atguigu.spring6.bean.User")
//@Component
//@Service
@Repository
//@Controller
//另外value其实可以不写，不写默认就是类的首字小写
public class User {


    private String name;

    private Integer id;
}
