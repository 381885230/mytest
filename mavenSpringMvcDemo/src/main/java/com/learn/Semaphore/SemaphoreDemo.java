package com.learn.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;

public class SemaphoreDemo {
//	private static final Semaphore semaphore = new Semaphore(3);// �ǹ�ƽ�ź���
//	private static final Semaphore semaphore=new Semaphore(3,true);//��ƽ�ź���
	private static final Semaphore semaphore=new Semaphore(1);//����ģʽ


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
				System.out.println(Thread.currentThread().getName() + ":��Һã�����"
						+ name + "�ҽ���" + age + "�굱ǰʱ��Ϊ��"
						+ System.currentTimeMillis());
				Thread.sleep(1000);
				System.out.println(name + "Ҫ׼���ͷ����֤�ˣ���ǰʱ��Ϊ��"
						+ System.currentTimeMillis());
				System.out
						.println("��ǰ��ʹ�õ������Ϊ��" + semaphore.availablePermits());
				semaphore.release();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		String[] name = { "����", "����", "�Ž�", "��ǿ", "�Զ�", "����", "����" };
		int[] age = { 26, 27, 33, 45, 19, 23, 41 };
		for (int i = 0; i < 7; i++) {
			Thread t1 = new InformationThread(name[i], age[i]);
			threadPool.execute(t1);
		}
	}

	
	
	
//	https://blog.csdn.net/carson0408/article/details/79475723
	/*
	 Semaphore��һ���ڶ��̻߳�����ʹ�õ���ʩ������ʩ����Э�������̣߳��Ա�֤�����ܹ���ȷ�������ʹ�ù�����Դ����ʩ��Ҳ�ǲ���ϵͳ�����ڿ��ƽ���ͬ�����������
	 Semaphore��һ�ּ����ź��������ڹ���һ����Դ���ڲ��ǻ���AQS�Ĺ���ģʽ�����൱�ڸ��̹߳涨һ�����Ӷ������������߳�����

	 1.����ԭ��
	         ��һ��ͣ����������Ϊ����Ϊ�˼����������ͣ����ֻ��������λ��һ��ʼ������λ���ǿյġ���ʱ���ͬʱ�����������������������������������谭�Ľ��룬
	         Ȼ����³�����ʣ�µĳ����������ڵȴ����˺����ĳ�Ҳ�����ò�����ڴ��ȴ�����ʱ����һ�����뿪ͣ�����������˵�֪�󣬴򿪳���������һ����������뿪������
	         ���ֿ��Է���������������������ͣ��ϵͳ�У�ÿ�����ͺñ�һ���̣߳������˾ͺñ�һ���ź����������������˿��Ի���̡߳�����������Ȼ��������λ��
	         ���ǿ����˸ı��˹���Ҫ��ÿ��ֻ��ͣ����������ôһ��ʼ����������������õȵ��г��뿪�����г����룬���ǵñ�֤���ͣ��������
	         ����Semaphore����ԣ�����ͬһ�������ˣ������˿ɻ���߳�����

	 Semaphore��Ҫ������

	 Semaphore(int permits):���췽�����������и���������ļ����ź���������Ϊ�ǹ�ƽ�ź�����

	 Semaphore(int permits,boolean fair):���췽������fair����trueʱ���������и���������ļ����ź���������Ϊ��ƽ�ź�����

	 void acquire():�Ӵ��ź�����ȡһ�����ǰ�߳̽�һֱ�������൱��һ����ռ��һ����λ��

	 void acquire(int n):�Ӵ��ź�����ȡ������Ŀ��ɣ����ṩ��Щ���ǰһֱ���߳�����������n=2�����൱��һ����ռ��������λ��

	 void release():�ͷ�һ����ɣ����䷵�ظ��ź���������ͬ�����߷���һ����λ��

	 void release(int n):�ͷ�n����ɡ�

	 int availablePermits()����ǰ���õ��������
	 
	  Semaphore��Ҫ���ڿ��Ƶ�ǰ��߳���Ŀ������ͬͣ����ϵͳһ�㣬��Semaphore���൱�ڿ��ص��ˣ����ڿ����ܹ�����ͣ����ͣ��λ�ĸ�����������ÿ������˵����ͬһ���̣߳�
	  �߳���Ҫͨ��acquire()������ȡ��ɣ���release()�ͷ���ɡ����������ﵽ���������ô����acquire()֮�󣬱����ȴ����У��ȴ��ѻ����ɵ��߳��ͷ���ɣ�
	  �Ӷ�ʹ�ö��߳��ܹ���������С�
	
	*/
	
}
