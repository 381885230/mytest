package com.learn.synchronizedtest.reentry;
 
//结论：在执行到sayHello2时，线程9又重新获取了新的锁，所以没有产生死锁。
//而因为是对象锁，所以一直到线程9执行完，线程            10才开始执行run模块代码
public class Test {
 
	/**
	 * @Title : main
	 * @Description ： mian方法
	 * @param args
	 * @return: void
	 * @author : juque
	 * @date : 2018-08-27 15:51:04
	 */
	public static void main(String[] args) {
 
		MyRunnable myRunnable = new MyRunnable();
 
		Thread thread = new Thread(myRunnable);
		thread.start();
 
		Thread thread1 = new Thread(myRunnable);
		thread1.start();
 
	}
 
}
