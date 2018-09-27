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
// ʹ�á� ������ʾ����������Խ���T��Ӧ�����Կ������κ���������
	public static void function(Student<?> s) {
		System.out.println("�����ǣ�" + s.getName());
	}

	/**
	 * ����һ���ʱ����Щ����ֻ�ܴ���һ�����������ͣ�
	 * ��ʱ��Ϳ���ʹ�����޺�������ȷ�������Χ����ʽ���£�
	 * �������ޣ�<? extends ��>
	 * �������ޣ�<? super ��>
	 * @param s
	 */
	
	//��ʾֻ�ܽ���Number������Լ�������������������͡���extends��̳У��������������Ķ�����
	public static void functionDown(Student<? extends Number> s){
		System.out.println("�����ǣ�"+s.getName());
	}
	
	//��ʾֻ�ܽ���Number������Լ������ĸ�����������͡���super���࣬���������Ķ�����
	public static void functionUp(Student<? super Double> s){
		System.out.println("�����ǣ�"+s.getName());
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
