package com.yuanjin.classlearn;

import java.lang.reflect.Field;

/**
 * Created by zejian on 2017/5/1. Blog : http://blog.csdn.net/javazejian
 * [原文地址,请尊重原创]
 */
public class ReflectField {

	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		Class<?> clazz = Class.forName("com.yuanjin.classlearn.Student");
		// 获取指定字段名称的Field类,注意字段修饰符必须为public而且存在该字段,
		// 否则抛NoSuchFieldException
		Field field = clazz.getField("age");
		System.out.println("field:" + field);

		// 获取所有修饰符为public的字段,包含父类字段,注意修饰符为public才会获取
		Field fields[] = clazz.getFields();
		for (Field f : fields) {
			System.out.println("f:" + f.getDeclaringClass());
		}

		System.out
				.println("================getDeclaredFields====================");
		// 获取当前类所字段(包含private字段),注意不包含父类的字段
		Field fields2[] = clazz.getDeclaredFields();
		for (Field f : fields2) {
			System.out.println("f2:" + f.getDeclaringClass());
		}
		// 获取指定字段名称的Field类,可以是任意修饰符的自动,注意不包含父类的字段
		Field field2 = clazz.getDeclaredField("desc");
		System.out.println("field2:" + field2);
		
		System.out.println("---------------------------------------------------------------------");
		
		
		//获取Class对象引用
		Class<?> clazz2 = Class.forName("com.yuanjin.classlearn.Student");

		Student st= (Student) clazz2.newInstance();
		//获取父类public字段并赋值
		Field ageField = clazz2.getField("age");
		ageField.set(st,18);
		Field nameField = clazz2.getField("name");
		nameField.set(st,"Lily");

		//只获取当前类的字段,不获取父类的字段
		Field descField = clazz2.getDeclaredField("desc");
		descField.set(st,"I am student");
		Field scoreField = clazz2.getDeclaredField("score");
		//设置可访问，score是private的
		scoreField.setAccessible(true);
		scoreField.set(st,88);
		System.out.println(st.toString());

		//输出结果：Student{age=18, name='Lily ,desc='I am student', score=88} 

		//获取字段值
		System.out.println(scoreField.get(st));
		// 88		
		
		
		
		
		
	}
	/**
	 * 输出结果: field:public int reflect.Person.age f:public java.lang.String
	 * reflect.Student.desc f:public int reflect.Person.age f:public
	 * java.lang.String reflect.Person.name
	 * 
	 * ================getDeclaredFields==================== f2:public
	 * java.lang.String reflect.Student.desc f2:private int
	 * reflect.Student.score field2:public java.lang.String reflect.Student.desc
	 */
}

class Person {
	public int age;
	public String name;
	// 省略set和get方法
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

class Student extends Person {
	public String desc;
	private int score;
	// 省略set和get方法
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}