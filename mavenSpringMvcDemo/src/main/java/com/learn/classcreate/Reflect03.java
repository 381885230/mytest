package com.learn.classcreate;

public class Reflect03 {

	public static void main(String[] args) throws Exception {

		Class c1 = Class.forName("com.learn.classcreate.Person");

		// 创建此Class对象所表示类的一个新实例,
		// newInstance方法调用的是Person的空参数构造方法
		Object o = c1.newInstance();
		System.out.println(o.toString());
	}
}