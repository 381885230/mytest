package com.learn.proxy.cglib;

/*
 * ������
 */
public class Test {
	public static void main(String[] args) {
		// Ŀ�����
		Singer target = new Singer();
		// �������
		Singer proxy = (Singer) new ProxyFactory(target).getProxyInstance();
		// ִ�д������ķ���
		proxy.sing();
	}
}