package com.learn.callback2;

public class SuperCalculator {
	public void add(int a, int b, doJob customer) {
		int result = a + b;
		customer.fillBlank(a, b, result);
	}
}