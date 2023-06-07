package com.atguigu.spring6.validator.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */

//校验测试
public class testPerson {
    public static void main(String[] args) {
        //创建Person对象
        Person person = new Person();
        person.setAge(250);
        //创建person对应的databinder
        DataBinder dataBinder = new DataBinder(person);
        //设置校验器
        dataBinder.setValidator(new PersonValidator());
        //调用方法执行校验
        dataBinder.validate();
        //输出校验结果
        BindingResult bindingResult = dataBinder.getBindingResult();
        System.out.println(bindingResult.getAllErrors());
    }
}
