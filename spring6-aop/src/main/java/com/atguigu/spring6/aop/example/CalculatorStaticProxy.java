package com.atguigu.spring6.aop.example;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public class CalculatorStaticProxy implements Calculator{

    //被代理的目标传入进来
    private Calculator calculator;

    //把被代理的目标写死了就是静态代理
    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        //日志
        System.out.println("[日志] add 方法开始");
        int add = calculator.add(i, j);
        System.out.println("[日志] add 方法结束");
        return add;
    }

    @Override
    public int sub(int i, int j) {
        //日志
        System.out.println("[日志] sub 方法开始");
        int sub = calculator.sub(i, j);
        System.out.println("[日志] sub 方法结束");
        return sub;
    }

    @Override
    public int mul(int i, int j) {
        //日志
        System.out.println("[日志] mul 方法开始");
        int mul = calculator.sub(i, j);
        System.out.println("[日志] mul 方法结束");
        return mul;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日志] div 方法开始");
        int div = calculator.div(i, j);
        System.out.println("[日志] div 方法结束");
        return div;
    }
}
