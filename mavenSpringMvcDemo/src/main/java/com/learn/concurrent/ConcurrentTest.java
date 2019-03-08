package com.learn.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentTest{
	Lock lock = new ReentrantLock();

	public static synchronized void testSyncronized() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" run testSyncronized,time="+System.currentTimeMillis());
	}

	public void testLock() {
		lock.lock();
		try {
			System.out.println("run testLock,time="+System.currentTimeMillis());
		} catch (Exception e) {
			System.out.println("err:"+e);
		} finally {
			lock.unlock();
		}
	}

	public static void testNoControl() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
		System.out.println("run testNoControl,time="+System.currentTimeMillis());
	}

	
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++){
			new Thread(){
				public void run(){
//					ConcurrentTest.testNoControl();
//					new ConcurrentTest().testLock();
					ConcurrentTest.testSyncronized();
				}
			}.start();
		}
		
	}
}
