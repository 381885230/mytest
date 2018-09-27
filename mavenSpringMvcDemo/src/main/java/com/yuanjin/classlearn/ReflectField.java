package com.yuanjin.classlearn;

import java.lang.reflect.Field;

/**
 * Created by zejian on 2017/5/1. Blog : http://blog.csdn.net/javazejian
 * [ԭ�ĵ�ַ,������ԭ��]
 */
public class ReflectField {

	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		Class<?> clazz = Class.forName("com.yuanjin.classlearn.Student");
		// ��ȡָ���ֶ����Ƶ�Field��,ע���ֶ����η�����Ϊpublic���Ҵ��ڸ��ֶ�,
		// ������NoSuchFieldException
		Field field = clazz.getField("age");
		System.out.println("field:" + field);

		// ��ȡ�������η�Ϊpublic���ֶ�,���������ֶ�,ע�����η�Ϊpublic�Ż��ȡ
		Field fields[] = clazz.getFields();
		for (Field f : fields) {
			System.out.println("f:" + f.getDeclaringClass());
		}

		System.out
				.println("================getDeclaredFields====================");
		// ��ȡ��ǰ�����ֶ�(����private�ֶ�),ע�ⲻ����������ֶ�
		Field fields2[] = clazz.getDeclaredFields();
		for (Field f : fields2) {
			System.out.println("f2:" + f.getDeclaringClass());
		}
		// ��ȡָ���ֶ����Ƶ�Field��,�������������η����Զ�,ע�ⲻ����������ֶ�
		Field field2 = clazz.getDeclaredField("desc");
		System.out.println("field2:" + field2);
		
		System.out.println("---------------------------------------------------------------------");
		
		
		//��ȡClass��������
		Class<?> clazz2 = Class.forName("com.yuanjin.classlearn.Student");

		Student st= (Student) clazz2.newInstance();
		//��ȡ����public�ֶβ���ֵ
		Field ageField = clazz2.getField("age");
		ageField.set(st,18);
		Field nameField = clazz2.getField("name");
		nameField.set(st,"Lily");

		//ֻ��ȡ��ǰ����ֶ�,����ȡ������ֶ�
		Field descField = clazz2.getDeclaredField("desc");
		descField.set(st,"I am student");
		Field scoreField = clazz2.getDeclaredField("score");
		//���ÿɷ��ʣ�score��private��
		scoreField.setAccessible(true);
		scoreField.set(st,88);
		System.out.println(st.toString());

		//��������Student{age=18, name='Lily ,desc='I am student', score=88} 

		//��ȡ�ֶ�ֵ
		System.out.println(scoreField.get(st));
		// 88		
		
		
		
		
		
	}
	/**
	 * ������: field:public int reflect.Person.age f:public java.lang.String
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
	// ʡ��set��get����
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
	// ʡ��set��get����
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