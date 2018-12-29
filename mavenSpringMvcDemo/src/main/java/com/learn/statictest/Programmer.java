package com.learn.statictest;
public class Programmer {
	/**
	 * 全局变量：也叫成员变量，是指在类中定义的变量；
	 * 它在整个类中都有效。全局变量分为：类变量和实例变量。
	 */
	private int age = 0;	//实例域
	private static int nextId;	//静态域（类变量）
	private final String name;	//final实例域
	private static final double PI = 3.14;	//静态常量
	
	public Programmer(String name) {
		this.name = name;
	}
    public static int getNextId(){
		//Cannot use this in a static context
		//System.out.println(this.name);
//		Cannot make a static reference to the non-static field name
//		return name;
		return nextId;
	}
	public static void main(String[] args) {
		/**
		 * 局部变量：是指那些在方法体中定义的变量以及方法的参数 ；
		 * 它只在定义它的方法内有效。
		 */
		int age = 20;	//局部变量
		Programmer test = new Programmer("xiaoyu");
		System.out.println(age);
		System.out.println(test.name);
	}
}
