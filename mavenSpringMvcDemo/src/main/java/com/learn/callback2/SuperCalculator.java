package com.learn.callback2;

public class SuperCalculator {
	public void add(int a, int b, CallBack customer) {
		int result = a + b;
		customer.fillBlank(a, b, result);
	}
}