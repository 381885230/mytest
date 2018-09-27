package com.learn.gc;

public class ReferenceCountingGC {
	public Object instance = null;

	public static void testGC() {

		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();

		// 对象之间相互循环引用，对象objA和objB之间的引用计数永远不可能为 0
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