package com.learn.synchronizedtest.test1;

public class App {

	public synchronized void test1() {

	}

	public void test2() {

		synchronized (this) {

		}

	}

	public static void main(String[] args) {

		System.out.println("Hello World!");

	}
}