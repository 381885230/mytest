package com.yuanjin.aop;
public class DynaTest {
    public static void main(String[] args) {
        IHello hello = (IHello) new DynaProxyHello().bind(new Hello());//���������Ҫ��־���ܣ���ʹ�ô�����
        //IHello hello = new Hello();//������ǲ���Ҫ��־������ʹ��Ŀ����
        hello.sayHello("����");
    }
}