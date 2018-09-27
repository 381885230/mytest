package com.learn.genericity;

class Student<T> {
	private T name;

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}
}

public class GenericDemo01 {
// 使用“ ？”表示这个方法可以接收T对应的属性可以是任何数据类型
	public static void function(Student<?> s) {
		System.out.println("姓名是：" + s.getName());
	}

	/**
	 * 但是一般的时候，有些方法只能处理一部分数据类型，
	 * 这时候就可以使用上限和下限来确定这个范围，格式如下：
	 * 泛型上限：<? extends 类>
	 * 泛型下限：<? super 类>
	 * @param s
	 */
	
	//表示只能接收Number这个类以及这个类的子类的数据类型。（extends表继承，就是这个类下面的东西）
	public static void functionDown(Student<? extends Number> s){
		System.out.println("姓名是："+s.getName());
	}
	
	//表示只能接收Number这个类以及这个类的父类的数据类型。（super表父类，超过这个类的东西）
	public static void functionUp(Student<? super Double> s){
		System.out.println("姓名是："+s.getName());
	}
	
	
	public static void main(String[] args) {
		Student<String> s = new Student<String>();
		s.setName("Haizhu");
		function(s);
		Student<Integer> s2 = new Student<Integer>();
		s2.setName(666);
		function(s2);
		
		Student<Integer> s3 = new Student<Integer>();
		s3.setName(666);
		functionDown(s3);		
		
		Student<Number> s4 = new Student<Number>();
		s4.setName(666);
		functionUp(s4);			
	}
}
