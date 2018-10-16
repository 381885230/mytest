package com.learn.designpattern.cglibproxy;

import org.junit.Test;

import com.learn.designpattern.proxy.UserDao;

/**
* 测试类
*/
public class App {

   @Test
   public void test(){
       //目标对象
       UserDao target = new UserDao();

       //代理对象
       UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();

       //执行代理对象的方法
       proxy.save();
   }
}