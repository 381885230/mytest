package com.yuanjin.classlearn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zejian on 2017/5/1. Blog : http://blog.csdn.net/javazejian
 * [ԭ�ĵ�ַ,������ԭ��]
 */
public class ReflectMethod {

	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Class clazz = Class.forName("com.yuanjin.classlearn.Circle");

		// ���ݲ�����ȡpublic��Method,�����̳��Ը���ķ���
		Method method = clazz.getMethod("draw", int.class, String.class);

		System.out.println("method:" + method);

		// ��ȡ����public�ķ���:
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			System.out.println("m::" + m);
		}

		System.out.println("=========================================");

		// ��ȡ��ǰ��ķ�������private,�÷����޷���ȡ�̳��Ը����method
		Method method1 = clazz.getDeclaredMethod("drawCircle");
		System.out.println("method1::" + method1);
		// ��ȡ��ǰ������з�������private,�÷����޷���ȡ�̳��Ը����method
		Method[] methods1 = clazz.getDeclaredMethods();
		for (Method m : methods1) {
			System.out.println("m1::" + m);
		}

		Class clazz2 = Class.forName("com.yuanjin.classlearn.Circle");
		// ��������
		Circle circle = (Circle) clazz2.newInstance();

		// ��ȡָ�������ķ�������Method
		Method method22 = clazz2.getMethod("draw", int.class, String.class);

		// ͨ��Method�����invoke(Object obj,Object... args)��������
		method22.invoke(circle, 15, "ȦȦ");

		// ��˽���޲η����Ĳ���
		Method method11 = clazz2.getDeclaredMethod("drawCircle");
		// �޸�˽�з����ķ��ʱ�ʶ
		method11.setAccessible(true);
		method11.invoke(circle);

		// ���з���ֵ�÷�������
		Method method2 = clazz2.getDeclaredMethod("getAllCount");
		Integer count = (Integer) method2.invoke(circle);
		System.out.println("count:" + count);

		/**
		 * ������: draw ȦȦ,count=15 drawCircle count:100
		 *
		 * 
		 * 
		 * 
		 * 
		 * }
		 * 
		 * /** ������: method:public void reflect.Shape.draw(int,java.lang.String)
		 * 
		 * m::public int reflect.Circle.getAllCount() m::public void
		 * reflect.Shape.draw() m::public void
		 * reflect.Shape.draw(int,java.lang.String) m::public final void
		 * java.lang.Object.wait(long,int) throws java.lang.InterruptedException
		 * m::public final native void java.lang.Object.wait(long) throws
		 * java.lang.InterruptedException m::public final void
		 * java.lang.Object.wait() throws java.lang.InterruptedException
		 * m::public boolean java.lang.Object.equals(java.lang.Object) m::public
		 * java.lang.String java.lang.Object.toString() m::public native int
		 * java.lang.Object.hashCode() m::public final native java.lang.Class
		 * java.lang.Object.getClass() m::public final native void
		 * java.lang.Object.notify() m::public final native void
		 * java.lang.Object.notifyAll()
		 * 
		 * ========================================= method1::private void
		 * reflect.Circle.drawCircle()
		 * 
		 * m1::public int reflect.Circle.getAllCount() m1::private void
		 * reflect.Circle.drawCircle()
		 */
	}

	class Shape {
		public void draw() {
			System.out.println("draw");
		}

		public void draw(int count, String name) {
			System.out.println("draw " + name + ",count=" + count);
		}

	}

	class Circle extends Shape {

		private void drawCircle() {
			System.out.println("drawCircle");
		}

		public int getAllCount() {
			return 100;
		}
	}
}