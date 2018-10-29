package com.learn.synchronizedtest.reentry;
 
/**
 * @package : cn.brian.reentry
 * @author : juque
 * @date : 2018-08-27 15:44:37
 * @description : 锁的重入。synchronized锁的是对象，在执行到sayHello2时，线程又重新获取了新的锁，所以没有产生死锁。而因为锁的是对象，所以一直到线程9执行完，线程10才开始执行
 *
 */
public class MyRunnable implements Runnable {
 
	public void run() {
		synchronized (this) {
			sayHello1();
			sayHello2();
		}
	}
 
	public void sayHello1() {
		System.out.println(Thread.currentThread().getName() + ";-->say hello one!");
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 
	synchronized public void sayHello2() {
		System.out.println(Thread.currentThread().getName() + ";-->say hello two!");
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 
}
