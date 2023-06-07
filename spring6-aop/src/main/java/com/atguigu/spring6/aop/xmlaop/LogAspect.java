package com.atguigu.spring6.aop.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author by KingOfTetris
 * @date 2023/5/25
 */

//切面类
@Component //Spring创建对象
public class LogAspect {
    //设置切入点和通知类型
    //通知类型:前置，返回，异常，后置，环绕
    //前置 @Before(value="切入点表达式配置切入点")
    //
//    @Before(value = "execution(public int com.atguigu.spring6.aop.annoaop.CalculatorImpl.add())") //前置


    //包com.atguigu.spring6.aop.annoaop下所有类的所有方法都加上前置通知
//    @Before(value = "execution(* com.atguigu.spring6.aop.annoaop.*.*(..))") //前置

    //对impl中所有的方法进行前置通知 要注意最后的两个(..)表示任意参数，不是两个参数。这个时候任意参数不是用*来表示的
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger--->前置通知,方法名称:" + methodName + ",参数" + Arrays.toString(args));
    }

    //返回通知和后置通知的区别在于，返回通知能得到返回值

//    @AfterReturning(value = "com.atguigu.spring6.aop.annoaop.LogAspect.pointCut()")
    //同一个切面直接调用方法名就行了，不同的切面还要加上包名
    //注意注解里面returning随便起名字，但是要和形参名保持一致。
    public void afterReturningMethod(JoinPoint joinPoint,Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger--->返回通知,方法名称:" + methodName + ",返回值是:" + result);
    }
//

    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger--->异常通知,方法名称:" + methodName + ",异常信息是" + ex);
    }

//

    public void afterMethod(JoinPoint joinPoint){
        //可以从连接点取得一些相信，比如方法的名字，参数个数，返回值，权限等
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger--->后置通知,方法名称:" + methodName);
    }

    //ProceedingJoinPoint比JoinPoint要强一些，能让目标方法执行
    //另外环绕通知是可以带有返回值的
    //环绕通知除了目标方法之前的操作，其他都是在其他通知之和出现。
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("环绕通知==目标方法之前");
            //调用目标方法
            result = proceedingJoinPoint.proceed();
            System.out.println("我是环绕通知执行目标方法后的返回值" + result);
            //
            System.out.println("环绕通知==目标方法返回值之后");
        }
        catch (Throwable throwable){
            System.out.println("环绕通知==目标方法出现异常");
        }
        finally {
            System.out.println("环绕通知==目标方法执行完毕之后");
        }

        return result;
    }
}
