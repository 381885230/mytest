package com.yuanjin.thread.method;

public class TestDaemon {
	public static void main(String[] args) {

		// Rose,������:ǰ̨�߳�
		Thread rose = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rose:��������AAAAAAaaaaaa....");
				System.out.println("��ͨ��");
			}
		};

		// jack,������:��̨�߳�
		Thread jack = new Thread() {
			public void run() {
				while (true) {
					System.out.println("jack:you jump!i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		/*
		 * ����Ϊ��̨�߳� ���ú�̨�̵߳ķ���Ҫ�ڸ��̱߳�����start()����֮ǰ����
		 */
		jack.setDaemon(true);
		rose.start();
		jack.start();
	}
}
