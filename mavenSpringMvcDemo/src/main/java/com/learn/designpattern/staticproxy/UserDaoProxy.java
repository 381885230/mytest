package com.learn.designpattern.staticproxy;

import com.learn.designpattern.proxy.IUserDao;

/**
* ��������,��̬����
*/
public class UserDaoProxy implements IUserDao{
   //���ձ���Ŀ�����
   private IUserDao target;
   public UserDaoProxy(IUserDao target){
       this.target=target;
   }

   public void save() {
       System.out.println("��ʼ����...");
       target.save();//ִ��Ŀ�����ķ���
       System.out.println("�ύ����...");
   }
}