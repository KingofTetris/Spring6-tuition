package com.atguigu.spring6.aop.example;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public class TestCal {
    public static void main(String[] args) {
        //动态创建代理对象
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        //执行目标方法
        proxy.add(2,2);
        proxy.sub(2,2);
        proxy.mul(2,2);
        proxy.div(2,2);
    }
}
