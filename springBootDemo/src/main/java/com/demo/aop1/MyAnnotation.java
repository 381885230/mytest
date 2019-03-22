/*package com.demo.aop1;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)//注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Documented//说明该注解将被包含在javadoc中
@Order(Ordered.HIGHEST_PRECEDENCE)//最高优先级
public @interface MyAnnotation {
    *//**
     * 自定义异常信息
     * @return 默认空字符串
     *//*
    String msg() default "";
    
    *//**
     * 功能名称
     * @return
     *//*
    String functionName() default "超级好友";

    *//**
     * 是否打印堆栈信息
     * @return 默认true
     *//*
    boolean printStackTrace() default true;
}
*/