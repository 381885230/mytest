package com.learn.annotation.inherited;

@BTable
public class Sub extends Super {
	private int subx;
	public int suby;

	private Sub() {
	}

	public Sub(int i) {
	}

	private int subX() {
		return 0;
	}

	public int subY() {
		return 0;
	}
}
