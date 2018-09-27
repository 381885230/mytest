package com.learn.designpattern.cglibproxy;

import org.junit.Test;

import com.learn.designpattern.proxy.UserDao;

/**
* ������
*/
public class App {

   @Test
   public void test(){
       //Ŀ�����
       UserDao target = new UserDao();

       //�������
       UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();

       //ִ�д������ķ���
       proxy.save();
   }
}