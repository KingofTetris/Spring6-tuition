package com.atguigu.spring6.aop.example;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public class CalculatorLogImpl implements Calculator{

    @Override
    public int add(int i, int j) {
        System.out.println("[日志] add 方法开始");
        int result = i + j;
        System.out.println("方法内部result = " + result);
        System.out.println("[日志] add 方法结束");
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("[日志] sub 方法开始");
        int result = i - j;
        System.out.println("方法内部result = " + result);
        System.out.println("[日志] sub 方法结束");
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("[日志] mul 方法开始");
        int result = i * j;
        System.out.println("方法内部result = " + result);
        System.out.println("[日志] mul 方法开始");
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日志] div 方法开始");
        int result = i / j;
        System.out.println("方法内部result = " + result);
        System.out.println("[日志] div 方法开始");
        return result;
    }
}
