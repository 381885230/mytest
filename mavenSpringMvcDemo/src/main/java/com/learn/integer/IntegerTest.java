package com.learn.integer;
/*
��ǿ�ơ����е���ͬ���͵İ�װ�����֮��ֵ�ıȽϣ�ȫ��ʹ��equals�����Ƚϡ� 
˵��������Integer var=?��-128��127֮��ĸ�ֵ��Integer��������IntegerCache.cache�������Ḵ�����ж���
		��������ڵ�Integerֵ����ֱ��ʹ��==�����жϣ������������֮����������ݣ������ڶ��ϲ����������Ḵ�����ж�������һ����ӣ�
		�Ƽ�ʹ��equals���������жϡ���ǿ�ơ����е���ͬ���͵İ�װ�����֮��ֵ�ıȽϣ�ȫ��ʹ��equals�����Ƚϡ� 
		˵��������Integer var=?��-128��127֮��ĸ�ֵ��Integer��������IntegerCache.cache�������Ḵ�����ж�����������ڵ�Integerֵ����ֱ��ʹ��==�����жϣ�
		�����������֮����������ݣ������ڶ��ϲ����������Ḵ�����ж�������һ����ӣ��Ƽ�ʹ��equals���������жϡ�
*/
public class IntegerTest {

	public static void main(String[] args) {

		Integer a=127;
		Integer b=127;
		
		Integer c=-128;
		Integer d=-128;
		
		Integer e=227;
		Integer f=227;
		
		Integer g=-137;
		Integer h=-137;
		
		System.out.println(a==b);
		System.out.println(c==d);
		System.out.println(e==f);
		System.out.println(g==h);	
		System.out.println(a.equals(b));
		System.out.println(c.equals(d));		
		System.out.println(e.equals(f));
		System.out.println(g.equals(h));		
	}

}
