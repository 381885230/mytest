package com.learn.delayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("00000001");
		list.add("00000002");
		list.add("00000003");
		list.add("00000004");
		list.add("00000005");
		DelayQueue<OrderDelay> queue = new DelayQueue<OrderDelay>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			// �ӳ�����ȡ��
			queue.put(new OrderDelay(list.get(i), TimeUnit.NANOSECONDS.convert(
					3, TimeUnit.SECONDS)));
			try {
				queue.take().print();
				System.out.println("After "
						+ (System.currentTimeMillis() - start)
						+ " MilliSeconds");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}