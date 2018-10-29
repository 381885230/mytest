package com.learn.synchronizedtest;

/*一段synchronized的代码被一个线程执行之前，他要先拿到执行这段代码的权限，在Java里边就是拿到某个同步对象的锁（一个对象只有一把锁）；
 如果这个时候同步对象的锁被其他线程拿走了，他（这个线程）就只能等了（线程阻塞在锁池等待队列中）。 
取到锁后，他就开始执行同步代码(被synchronized修饰的代码）；线程执行完同步代码后马上就把锁还给同步对象，其他在锁池中等待的某个线程就可以拿到锁执行同步代码了。
		这样就保证了同步代码在统一时刻只有一个线程在执行。*/
public class SynWindow implements Runnable {
	Object object;
	Object object2;
	String name;
	static int count = 10;

	public SynWindow(String name, Object object, Object object2) {
		this.object = object;
		this.object2 = object2;
		this.name = name;
	}

	public void serviceWindow() {
		while (count > 0) {
			synchronized (object) {
				synchronized (object2) {
					System.out.println(getName() + "服务" + count + "号客户");
					count -= 1;
					object2.notify();
				}
				try {
					object.wait();
				} catch (Exception e) {
				}
			}
		}

	}

	@Override
	public void run() {
		serviceWindow();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		SynWindow s1 = new SynWindow("窗口一", a, b);
		SynWindow s2 = new SynWindow("窗口二", b, c);
		SynWindow s3 = new SynWindow("窗口三", c, a);
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		Thread t3 = new Thread(s3);
		t1.start();
		try {
			t1.sleep(100);
		} catch (Exception e) {
		}
		t2.start();
		t3.start();
	}

}
