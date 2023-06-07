package com.atguigu.spring6.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */
public class ProxyFactory {

    //目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回动态代理
    public Object getProxy(){
        /**
         * 3个参数
         * 1.ClassLoader loader
           加载动态生成代理类的类加载器
         * 2. Class<?>[] interfaces
           目标对象实现的所有接口的class数组
         * 3.InvocationHandler h
           设置代理对象实现目标对象方法的过程
         */
        //加载动态生成代理类的类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //目标对象实现的所有接口的class数组
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //设置代理对象实现目标对象方法的过程
        //InvocationHandler是个接口，懒得去用类实现了
        //快速使用匿名内部类实现
       InvocationHandler invocationHandler = new InvocationHandler() {
           @Override
           //Object proxy 代理
           //Method method 需要重写的目标方法
           //Object[] args method方法中的参数
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               //调用前
               System.out.println("[动态代理][日志]，调用" + method.getName() + "前,参数" + Arrays.toString(args));
               //调用目标方法
               //注意被代理的对象target不是proxy
               Object result = method.invoke(target, args);
               //调用后
               System.out.println("[动态代理][日志]，调用" + method.getName() + "后,结果" + result);
               return result;
           }
       };

       //Java.lang包实现了代理模式，用Proxy的newProxyInstance实现
       return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
