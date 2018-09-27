package com.yuanjin.thread.method;

/**
 * ʹ��wait()��notify()��������߳�Эͬ����
 */
public class TestWaitNotify {

	public static boolean isFinish = false;
	public static Object object = new Object();

	public static void main(String[] args) {

		// ����ͼƬ���߳�
		final Thread download = new Thread() {
			public void run() {
				System.out.println("download:��ʼ����ͼƬ");
				for (int i = 0; i <= 100; i++) {
					System.out.println("download:�����" + i + "%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("download:ͼƬ�������");
				isFinish = true;// ��ʾͼƬ���������

				// ��ͼƬ������Ϻ󣬾Ϳ���֪ͨshowImg��ʼ��ʾͼƬ��
				synchronized (object) {
					// ֪ͨ��object���ϵȴ����߳̽���ȴ�����
					object.notify();
				}

				System.out.println("download:��ʼ���ظ���");
				for (int i = 0; i <= 100; i++) {
					System.out.println("download:�����" + i + "%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("download:�����������");
			}

		};

		// ������ʾͼƬ���߳�
		Thread showImg = new Thread() {
			public void run() {
				System.out.println("show:׼����ʾͼƬ");
				// �ȴ������߳̽�ͼƬ���ؽ�������ִ������Ĵ���
				try {
					// wait()������������������������,1:��download�߳̽���.
					// 2:��������download��notify()
					synchronized (object) {
						object.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (!isFinish) {
					throw new RuntimeException("ͼƬû���������");
				}
				System.out.println("show:ͼƬ�Ѿ���ʾ��!");
			}
		};

		download.start();
		showImg.start();
	}
}