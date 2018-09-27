package com.learn.gc;

public class ReferenceCountingGC {
	public Object instance = null;

	public static void testGC() {

		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();

		// ����֮���໥ѭ�����ã�����objA��objB֮������ü�����Զ������Ϊ 0
		objB.instance = objA;
		objA.instance = objB;

		objA = null;
		objB = null;

		System.gc();
		System.out.println(objA);
	}

	
	public static void main(String[] args) {
		testGC();
	}
}