package com.learn.proxy.staticProxy;

/*
 * ������
 */
public class Test {
	public static void main(String[] args) {
		// Ŀ�����
		ISinger target = new Singer();
		// �������
		ISinger proxy = new SingerProxy(target);
		// ִ�е��Ǵ���ķ���
		proxy.sing();
	}
}