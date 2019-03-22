package com.learn.synchronizedtest;

/**
 * 1、synchronized加在非静态方法前和synchronized(this)都是锁住了这个类的对象，如果多线程访问，对象不同，就锁不住，对象固定是一个，就可锁住。
2、synchronized(类名.class)和加在静态方法前，是锁住了代码块，不管多线程访问的时候对象是不是同一个，
能缩小代码段的范围就尽量缩小，能在代码段上加同步就不要再整个方法上加同步，缩小锁的粒度。
原文：https://blog.csdn.net/u011068702/article/details/80646679 
 * @author yuanjin
 * @date 2019年3月12日 下午11:35:12
 */
public class Synchronized {

	class Test {
		public synchronized void testFirst() {
			print("testFirst");
		}

		public void testSecond() {
			synchronized (this) {
				print("testSecond");
			}
		}

		public void testThird() {
			synchronized (Test.class) {
				print("testThird");
			}
		}

		public void print(String method) {
			System.out.println(method + "start");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(method + "end");
		}
	}

	class TestThread extends Thread {

		public int mType = 0;
		public Test mTest = null;

		public TestThread(int type, Test test) {
			this.mType = type;
			this.mTest = test;
		}

		public void run() {
			if (mTest == null) {
				if (mType == 1) {
					Test test = new Test();
					test.testFirst();
				} else if (mType == 2) {
					Test test = new Test();
					test.testSecond();
				} else if (mType == 3) {
					Test test = new Test();
					test.testThird();
				}
			} else {
				if (mType == 1) {
					mTest.testFirst();
				} else if (mType == 2) {
					mTest.testSecond();
				} else if (mType == 3) {
					mTest.testThird();
				}
			}
		}
	}

	public static void main(String[] args) {
		Synchronized syn = new Synchronized();
		Test test = syn.new Test();
		for (int i = 0; i < 5; ++i) {
			syn.new TestThread(1, null).start();
		}
	}
}