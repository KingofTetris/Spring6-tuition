package com.atguigu.spring6;

/**
 * @author by KingOfTetris
 * @date 2023/5/24
 */
public class User {
    private String name;

    //DI是IoC的实现方式
    //在Spring创建对象的过程中,通过配置文件实现对象的注入，就的DI 依赖注入
    //常见的方式有两种，setter注入和构造注入
    private Person person;

    public User() {
        System.out.println("空参构造器执行..");
    }

    public void add(){
        System.out.println("add...........");
    }
}
