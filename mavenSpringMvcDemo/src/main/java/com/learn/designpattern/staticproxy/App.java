package com.learn.designpattern.staticproxy;

import com.learn.designpattern.proxy.UserDao;

/**
* ������
*/
public class App {
   public static void main(String[] args) {
       //Ŀ�����
       UserDao target = new UserDao();

       //�������,��Ŀ����󴫸��������,���������ϵ
       UserDaoProxy proxy = new UserDaoProxy(target);

       proxy.save();//ִ�е��Ǵ���ķ���
   }
}