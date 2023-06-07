package com.atguigu.spring6.aop.annoaop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */

@Component
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法内部result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法内部result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法内部result = " + result);
        return result;
    }
}
