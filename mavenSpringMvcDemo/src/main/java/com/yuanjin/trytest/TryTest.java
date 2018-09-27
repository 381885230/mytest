package com.yuanjin.trytest;

public class TryTest {

	
	public static void main(String[] args) {
		int a=testTry();
		System.out.println(a);
	}
	
	static int testTry(){
		int a=4;
		try {
			a++;
			System.out.println(a);
			return a;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			a=8;
			System.out.println("a changed");
			return a;
		}
	}
	
}
