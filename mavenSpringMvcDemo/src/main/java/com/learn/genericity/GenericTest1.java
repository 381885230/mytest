package com.learn.genericity;

/**
 * ��ʹ�÷�����ʱ����Ȼ�����˲�ͬ�ķ���ʵ�Σ�����û���������������ɲ�ͬ�����ͣ�
 * ���벻ͬ����ʵ�εķ��������ڴ���ֻ��һ����������ԭ��������������ͣ���ʵ����ΪBox����
 * ��Ȼ�����߼������ǿ������ɶ����ͬ�ķ������͡�
����ԭ������Java�еķ�����һ���������Ŀ�ģ�������ֻ�������ڴ������׶Σ��ڱ�������У�
������ȷ���鷺�ͽ���󣬻Ὣ���͵������Ϣ������Ҳ����˵���ɹ���������class�ļ����ǲ������κη�����Ϣ�ġ�
������Ϣ������뵽����ʱ�׶Ρ�
�Դ��ܽ��һ�仰�������������߼��Ͽ��Կ����Ƕ����ͬ�����ͣ�ʵ���϶�����ͬ�Ļ������͡�
 * @author admin
 *
 */
public class GenericTest1 {

	public static void main(String[] args) {

		Box<String> name = new Box<String>("corn");
		System.out.println("name:" + name.getData());
		
		Box<Integer> age=new Box<Integer>(15);
		System.out.println("age:" + age.getData());

	}

}

class Box<T> {

	private T data;

	public Box() {

	}

	public Box(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

}