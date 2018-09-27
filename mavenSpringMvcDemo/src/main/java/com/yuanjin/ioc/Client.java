package com.yuanjin.ioc;

class Client {
	public static void main(String[] a) {
		Fruit f = Factory.getInstance("com.yuanjin.ioc.Apple");
		if (f != null) {
			f.eat();
		}
	}
}