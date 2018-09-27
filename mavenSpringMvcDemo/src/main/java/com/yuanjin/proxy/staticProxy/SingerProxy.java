package com.yuanjin.proxy.staticProxy;
/*
 *  ��������Ŀ�����ʵ����ͬ�Ľӿ�
 */
public class SingerProxy implements ISinger {
	// ����Ŀ������Ա����sing����
	private ISinger target;

	public SingerProxy(ISinger target) {
		this.target = target;
	}

	// ��Ŀ������sing�������й�����չ
	public void sing() {
		System.out.println("SingerProxy:������ʺ�");
		target.sing();
		System.out.println("SingerProxy:лл���");
	}
}