package com.atguigu.spring6.aop.annoaop;

import org.springframework.stereotype.Component;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */

@Component
public class Dog {

    //注意private的属性和方法只能在内部使用!!
    private void eat(int meat){
        System.out.println("dog eat" + (meat - 5));
    }
    public void run(int mile){
        System.out.println("dog run" + mile + "m");
    }
    public void train(){
        eat(22);
    }
}
