package com.learn.string.runtime;

//���Դ���  1-2ms
public class StringRunTime {
	public static void main(String[] args) {
		// �� ���Դ���λ��1
		String str = "";
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			// �� ���Դ���λ��2
			str = "Heart" + "Raid";
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}
}