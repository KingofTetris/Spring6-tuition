package com.atguigu.spring6.aop.annoaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public class testAOP {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.add(1,2);
        //        calculator.div(1,0);
        System.out.println();
        Dog dog = context.getBean(Dog.class);
        dog.train();
        dog.run(33);
    }
}
