package com.yuanjin.thread;

public class ThreadTest {
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				pong();
			}

		};

		t.run();
		System.out.println("ping");
	}

	static void pong() {
		System.out.println("pong");
	}
}
