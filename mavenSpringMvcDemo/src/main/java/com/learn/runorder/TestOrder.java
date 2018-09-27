package com.learn.runorder;

public class TestOrder {

	static class A {
		static {
			System.out.println("1");
		}

		public A() {
			System.out.println("2");
		}
	}

	static class B extends A {
		static {
			System.out.println("a");
		}

		public B() {
			System.out.println("b");
		}
	}

	public static void main(String[] args) {
		A ab = new B();
		ab = new B();
	}

}
