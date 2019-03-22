/*package com.demo.aop1;

import java.net.InetAddress;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAnnotationAspect {
    private Logger logger = LoggerFactory.getLogger(MyAnnotationAspect.class);
    *//**
     * AOP异常通知
     *
     * @param joinPoint 切入点
     * @param ex        异常
     *//*
    @After(value = "@annotation(com.demo.aop1.MyAnnotation)")
    public void interceptor(JoinPoint joinPoint, Exception ex) {
        try {
            String methodName = joinPoint.getSignature().getName();
            MyAnnotation myAnnotation = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(MyAnnotation.class);
            String msg = myAnnotation.msg();
            boolean printStackTrace = myAnnotation.printStackTrace();
            //错误信息
            InetAddress address = InetAddress.getLocalHost();
            String params = getParams(joinPoint);
            System.out.println("methodName========="+methodName);
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }


    *//**
     * @param joinPoint 截取点
     * @return 获取参数和参数名拼接的字符串
     *//*
    private String getParams(JoinPoint joinPoint) {
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();

        //获取被切参数名称及参数值
        StringBuilder paramBuilder = new StringBuilder();
        for (int i = 0; i < paramNames.length; i++) {
            paramBuilder.append("&").append(paramNames[i]).append("=").append(paramValues[i]);
        }
        if (paramBuilder.length() > 0) {
            return paramBuilder.substring(1);
        }
        return "";
    }
}
*/