package com.learn.synchronizedtest.test2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FriendsLockTest {

	public final static Lock lock=new ReentrantLock();
	
	public static void main(String[] args) {
		for(int i=0;i<3;i++){
			new TestThread().start();
		}
	}
	
	/**
	 * 模拟无锁
	 */
	public static void calc0(){
			System.out.println(Thread.currentThread().getName()+" begin calc,time="+System.currentTimeMillis());
			try {
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName()+" insert 100 to DB");
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" end calc,time="+System.currentTimeMillis());
			System.out.println("-----------------------------");
	}	
	
	
	/**
	 * 模拟超级好友佣金计算:静态方法模拟spring单例
	 * 不加锁是乱序执行，加锁时串行执行
	 * 不加锁，多个线程同时执行；加锁，单位时间只有一个获得锁，执行
	 * 模拟在方法上加锁
	 */
	public synchronized static void calc(){
		System.out.println(Thread.currentThread().getName()+" begin calc,time="+System.currentTimeMillis());
		try {
			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName()+" insert 100 to DB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" end calc,time="+System.currentTimeMillis());
		System.out.println("-----------------------------");
	}
	
	
	/**
	 * 模拟在类上加锁
	 */
	public static void calc2(){
		synchronized (FriendsLockTest.class) {
			System.out.println(Thread.currentThread().getName()+" begin calc,time="+System.currentTimeMillis());
			try {
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName()+" insert 100 to DB");
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" end calc,time="+System.currentTimeMillis());
			System.out.println("-----------------------------");
		}
	}
	
	/**
	 * Lock加锁
	 */
	public static void calc3(){
		lock.lock();
		System.out.println(Thread.currentThread().getName()+" begin calc,time="+System.currentTimeMillis());
		try {
			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName()+" insert 100 to DB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" end calc,time="+System.currentTimeMillis());
		System.out.println("-----------------------------");
		lock.unlock();
	}	
	
	
	
}

class TestThread extends Thread{
	public void run(){
//		FriendsLockTest.calc();
//		FriendsLockTest.calc2();
//		FriendsLockTest.calc0();
		FriendsLockTest.calc3();
	}
}