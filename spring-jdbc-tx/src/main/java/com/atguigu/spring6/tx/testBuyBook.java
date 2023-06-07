package com.atguigu.spring6.tx;

import com.atguigu.spring6.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author by KingOfTetris
 * @date 2023/5/26
 */
@SpringJUnitConfig(locations = "classpath:beans.xml")
public class testBuyBook {

    @Autowired
    private BookController controller;
    @Test
    public void test(){
        controller.buyBook(1,1);
    }


    //回滚是回滚了，但是你不能这么粗暴地返回出错吧。
    @Test
    public void test2(){
        //TODO 模拟超时
//        try {
//            TimeUnit.SECONDS.sleep(5);//模拟进程sleep 5s
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Map<Integer,Integer> items = new HashMap<>();
        items.put(1,200);
        items.put(2,200);
        controller.buyBooks(items,2);
//        System.out.println(1/0); //模拟出现一类异常，但是不回滚
    }
}
