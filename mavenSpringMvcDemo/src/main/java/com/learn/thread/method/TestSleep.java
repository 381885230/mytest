package com.learn.thread.method;

public class TestSleep {
	public static void main(String[] args) {
		/*
		 * �����ߣ�����˯���������̡߳� ��һ�������еľֲ��ڲ�������Ҫ���ø÷����������ֲ���������ô�������������final��
		 */
		final Thread lin = new Thread() {
			public void run() {
				System.out.println("��:�������ݣ�˯����!");
				try {
					// ��һ���̴߳���˯������ʱ�����������̵߳���interrupt()�����жϣ���sleep()�������׳�
					// InterruptedException�쳣
					Thread.sleep(100000000);
				} catch (InterruptedException e) {
					System.out.println("��:�����أ�����������!");
				}
			}
		};
		/*
		 * ������:�ж�˯���������߳�
		 */
		Thread huang = new Thread() {
			public void run() {
				System.out.println("��:��ʼ��ǽ��");
				for (int i = 0; i < 5; i++) {
					System.out.println("��:80!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("�۵�!");
				System.out.println("��:�㶨��");

				// �ж�lin��˯������
				lin.interrupt();
			}
		};
		lin.start();
		huang.start();
	}
}
