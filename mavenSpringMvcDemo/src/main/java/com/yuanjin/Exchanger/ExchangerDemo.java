package com.yuanjin.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * Exchanger�������ߣ���һ�������̼߳�Э���Ĺ����ࡣExchanger���ڽ����̼߳�����ݽ�����
 * ���ṩһ��ͬ���㣬�����ͬ���������߳̿��Խ����˴˵����ݡ��������߳�ͨ��exchange�����������ݣ� 
 * �����һ���߳���ִ��exchange����������һֱ�ȴ��ڶ����߳�Ҳִ��exchange���������̶߳�����ͬ����ʱ��
 * �������߳̾Ϳ��Խ������ݣ������߳��������������ݴ��ݸ��Է������ʹ��Exchanger���ص��ǳɶԵ��߳�ʹ��exchange()������
 * ����һ���̴߳ﵽ��ͬ���㣬�ͻ���н������ݡ���˸ù�������̶߳����ǳɶԵġ�
	Exchanger���ṩ������������String exchange(V x):���ڽ����������������ȴ���һ���̵߳���exchange��
	String exchange(V x,long timeout,TimeUnit unit)�����ڽ����������������ȴ���һ���̵߳���exchange��
	�����������ȴ�ʱ�䣬���ȴ�ʱ�䳬��timeout��ֹͣ�ȴ���
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