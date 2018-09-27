package com.yuanjin.thread.method;

public class TestPriority {
	public static void main(String[] args) {
		// ������ȼ����߳�
		Thread max = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("max");
				}
			}
		};
		// ������ȼ����߳�
		Thread min = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("min");
				}
			}
		};
		// Ĭ�����ȼ����߳�
		Thread norm = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("norm");
				}
			}
		};
		// void setPriority(int p),���õ�ǰ�̵߳����ȼ�, ��ߣ���ͣ�Ĭ�϶��г�����Ӧ��
		// ���������ȼ�Ҳ����100%�����̵߳��ȡ�ֻ�����̶ȵĸ�֪�̵߳����Ը���ļ��ʷ���ʱ��Ƭ���߳����ȼ��ߵ��߳�
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		// �������ÿ���ʡ�ԣ�Ĭ������¾��Ǹ�ֵ
		norm.setPriority(Thread.NORM_PRIORITY);

		min.start();
		norm.start();
		max.start();
	}
}
