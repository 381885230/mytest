package com.learn.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;

public class SemaphoreDemo {
//	private static final Semaphore semaphore = new Semaphore(3);// 非公平信号量
//	private static final Semaphore semaphore=new Semaphore(3,true);//公平信号量
	private static final Semaphore semaphore=new Semaphore(1);//单例模式


	private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
			5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

	private static class InformationThread extends Thread {
		private final String name;
		private final int age;

		public InformationThread(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public void run() {
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + ":大家好，我是"
						+ name + "我今年" + age + "岁当前时间为："
						+ System.currentTimeMillis());
				Thread.sleep(1000);
				System.out.println(name + "要准备释放许可证了，当前时间为："
						+ System.currentTimeMillis());
				System.out
						.println("当前可使用的许可数为：" + semaphore.availablePermits());
				semaphore.release();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		String[] name = { "李明", "王五", "张杰", "王强", "赵二", "李四", "张三" };
		int[] age = { 26, 27, 33, 45, 19, 23, 41 };
		for (int i = 0; i < 7; i++) {
			Thread t1 = new InformationThread(name[i], age[i]);
			threadPool.execute(t1);
		}
	}

	
	
	
//	https://blog.csdn.net/carson0408/article/details/79475723
	/*
	 Semaphore是一种在多线程环境下使用的设施，该设施负责协调各个线程，以保证它们能够正确、合理的使用公共资源的设施，也是操作系统中用于控制进程同步互斥的量。
	 Semaphore是一种计数信号量，用于管理一组资源，内部是基于AQS的共享模式。它相当于给线程规定一个量从而控制允许活动的线程数。

	 1.工作原理
	         以一个停车场是运作为例。为了简单起见，假设停车场只有三个车位，一开始三个车位都是空的。这时如果同时来了五辆车，看门人允许其中三辆不受阻碍的进入，
	         然后放下车拦，剩下的车则必须在入口等待，此后来的车也都不得不在入口处等待。这时，有一辆车离开停车场，看门人得知后，打开车拦，放入一辆，如果又离开两辆，
	         则又可以放入两辆，如此往复。这个停车系统中，每辆车就好比一个线程，看门人就好比一个信号量，看门人限制了可以活动的线程。假如里面依然是三个车位，
	         但是看门人改变了规则，要求每次只能停两辆车，那么一开始进入两辆车，后面得等到有车离开才能有车进入，但是得保证最多停两辆车。
	         对于Semaphore类而言，就如同一个看门人，限制了可活动的线程数。

	 Semaphore主要方法：

	 Semaphore(int permits):构造方法，创建具有给定许可数的计数信号量并设置为非公平信号量。

	 Semaphore(int permits,boolean fair):构造方法，当fair等于true时，创建具有给定许可数的计数信号量并设置为公平信号量。

	 void acquire():从此信号量获取一个许可前线程将一直阻塞。相当于一辆车占了一个车位。

	 void acquire(int n):从此信号量获取给定数目许可，在提供这些许可前一直将线程阻塞。比如n=2，就相当于一辆车占了两个车位。

	 void release():释放一个许可，将其返回给信号量。就如同车开走返回一个车位。

	 void release(int n):释放n个许可。

	 int availablePermits()：当前可用的许可数。
	 
	  Semaphore主要用于控制当前活动线程数目，就如同停车场系统一般，而Semaphore则相当于看守的人，用于控制总共允许停车的停车位的个数，而对于每辆车来说就如同一个线程，
	  线程需要通过acquire()方法获取许可，而release()释放许可。如果许可数达到最大活动数，那么调用acquire()之后，便进入等待队列，等待已获得许可的线程释放许可，
	  从而使得多线程能够合理的运行。
	
	*/
	
}
