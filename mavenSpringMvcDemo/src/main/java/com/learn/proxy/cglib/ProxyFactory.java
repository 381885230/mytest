package com.learn.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
  * Cglib�����������
  */
 public class ProxyFactory implements MethodInterceptor{
     // ά��Ŀ�����
     private Object target;
 
     public ProxyFactory(Object target) {
         this.target = target;
     }
 
     // ��Ŀ����󴴽�һ����������
     public Object getProxyInstance(){
         //1.������
         Enhancer en = new Enhancer();
         //2.���ø���
         en.setSuperclass(target.getClass());
         //3.���ûص�����
         en.setCallback(this);
         //4.��������(��������)
         return en.create();
     }
 
     @Override
     public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
         System.out.println("������ʺ�");
         //ִ��Ŀ�����ķ���
         Object returnValue = method.invoke(target, args);
         System.out.println("лл���");
         return returnValue;
     }
 }