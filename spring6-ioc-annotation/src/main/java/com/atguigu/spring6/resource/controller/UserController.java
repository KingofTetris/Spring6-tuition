package com.atguigu.spring6.resource.controller;

import com.atguigu.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */

//注意扫描包下如果有同类名的类存在，你要在创建对象的注解里面加上名字进行区分，
    //没写的相当于首字母小写userController，所以在这里加上myUserController进行区分
    //不然Spring就不知道去找哪个类进行创建。
@Controller("myUserController") //你要注入之前，是不是得先有个对象 <bean id="xxx" class=".....">
public class UserController {
    //Resource先根据名称进行匹配，有指定就根据指定的name进行匹配，
    //name不能省略，value可以省略。
//    @Resource(name = "myUserService")
//    private UserService userService;


    //注解里面没指定名字
    // 这里的属性名字userService和实现类里面的myUserDao也不一样
    //那么resource就会根据类型进行匹配
    @Resource
    private UserService userService;

    public void addUser(){
        System.out.println("controller方法执行了");
        userService.addUserService();
    }
}
