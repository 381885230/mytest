package com.learn.integer;
/*
【强制】所有的相同类型的包装类对象之间值的比较，全部使用equals方法比较。 
说明：对于Integer var=?在-128至127之间的赋值，Integer对象是在IntegerCache.cache产生，会复用已有对象，
		这个区间内的Integer值可以直接使用==进行判断，但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，这是一个大坑，
		推荐使用equals方法进行判断。【强制】所有的相同类型的包装类对象之间值的比较，全部使用equals方法比较。 
		说明：对于Integer var=?在-128至127之间的赋值，Integer对象是在IntegerCache.cache产生，会复用已有对象，这个区间内的Integer值可以直接使用==进行判断，
		但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，这是一个大坑，推荐使用equals方法进行判断。
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
