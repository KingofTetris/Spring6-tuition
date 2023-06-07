package com.atguigu.spring6.iocxml.lifecycle;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public class User {
    private String name;

    //初始化方法 名字随便起
    public void initMethod(){
        System.out.println("4 bean对象初始化，调用指定的初始化方法");
    }

    //销毁方法
    public void destroy(){
        System.out.println("7 bean对象的销毁，调用指定的销毁方法");
    }
    public User(){
        System.out.println("1.调用无参数构造，创建bean对象...");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2.对bean对象的属性进行赋值");
    }


}
