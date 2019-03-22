/*package com.demo.aop2;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

*//**
 * @author LinJie
 * log功能，不影响核心业务
 *//*
@Component("logginAspectJ")
@Aspect
public class LogginAspectJ {
    
     *定义一个方法,用于声明切点表达式,该方法一般没有方法体
     *@Pointcut用来声明切点表达式
     *通知直接使用定义的方法名即可引入当前的切点表达式 
     
    @Pointcut("execution(* com.linjie.aop.Arithmetic.*(..))")
    public void PointcutDeclaration() {}

    //前置通知,方法执行之前执行
    @Before("PointcutDeclaration()")
    public void BeforeMethod(JoinPoint jp) {    
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("BeforeMethod  The method   "+ methodName +"   parameter is  "+ Arrays.asList(args));
        System.out.println("add before");
        System.out.println();
    }

    //后置通知,方法执行之后执行(不管是否发生异常)
    @After("PointcutDeclaration()")
    public void AfterMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("AfterMethod  The method    "+ methodName +"   parameter is  "+Arrays.asList(args));
        System.out.println();
    }

    //返回通知,方法正常执行完毕之后执行
    @AfterReturning(value="PointcutDeclaration()",returning="result")
    public void AfterReturningMethod(JoinPoint jp,Object result) {
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("AfterReturningMethod  The method   "+ methodName +"   parameter is  "+Arrays.asList(args)+" "+result);
        System.out.println();
    } 

    //异常通知,在方法抛出异常之后执行
    @AfterThrowing(value="PointcutDeclaration()",throwing="e")
    public void AfterThrowingMethod(JoinPoint jp,Exception e) {
        String methodName = jp.getSignature().getName();
        System.out.println("AfterThrowingMethod  The method   "+ methodName +"exception :"+e);
    }
}
*/