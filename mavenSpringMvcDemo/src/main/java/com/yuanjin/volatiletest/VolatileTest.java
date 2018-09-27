package com.yuanjin.volatiletest;

public class VolatileTest {
	public static volatile int count=0;
	
	public static void add(){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count++;
	}
	
	public static void main(String[] args) throws InterruptedException {

		for(int i=0;i<1000;i++){
			new Thread(VolatileTest::add).start();
		}
		
		Thread.sleep(500);
		System.out.println(count);
	}

}
