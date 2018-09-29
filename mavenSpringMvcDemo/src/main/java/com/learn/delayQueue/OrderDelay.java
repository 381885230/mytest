package com.learn.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class OrderDelay implements Delayed {
	private String orderId;
	private long timeout;

	OrderDelay(String orderId, long timeout) {
		this.orderId = orderId;
		this.timeout = timeout + System.nanoTime();
	}

	public int compareTo(Delayed other) {
		if (other == this)
			return 0;
		OrderDelay t = (OrderDelay) other;
		long d = (getDelay(TimeUnit.NANOSECONDS) - t
				.getDelay(TimeUnit.NANOSECONDS));
		return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
	} // ���ؾ������Զ���ĳ�ʱʱ�仹�ж���

	public long getDelay(TimeUnit unit) {
		return unit.convert(timeout - System.nanoTime(), TimeUnit.NANOSECONDS);
	}

	void print() {
		System.out.println(orderId + "��ŵĶ���Ҫɾ������������");
	}
}