package com.learn.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * Exchanger（交换者）是一个用于线程间协作的工具类。Exchanger用于进行线程间的数据交换。
 * 它提供一个同步点，在这个同步点两个线程可以交换彼此的数据。这两个线程通过exchange方法交换数据， 
 * 如果第一个线程先执行exchange方法，它会一直等待第二个线程也执行exchange，当两个线程都到达同步点时，
 * 这两个线程就可以交换数据，将本线程生产出来的数据传递给对方。因此使用Exchanger的重点是成对的线程使用exchange()方法，
 * 当有一对线程达到了同步点，就会进行交换数据。因此该工具类的线程对象是成对的。
	Exchanger类提供了两个方法，String exchange(V x):用于交换，启动交换并等待另一个线程调用exchange；
	String exchange(V x,long timeout,TimeUnit unit)：用于交换，启动交换并等待另一个线程调用exchange，
	并且设置最大等待时间，当等待时间超过timeout便停止等待。
 * @author admin
 *
 */

public class ExchangerDemo {

	static Exchanger<String> exchanger = new Exchanger<String>();

	static class Task implements Runnable {
		@Override
		public void run() {
			try {
				String result = exchanger.exchange(Thread.currentThread().getName());
				System.out.println("this is "
						+ Thread.currentThread().getName() + " receive data:"
						+ result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {

		Thread t1 = new Thread(new Task(), "thread1");
		Thread t2 = new Thread(new Task(), "thread2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}