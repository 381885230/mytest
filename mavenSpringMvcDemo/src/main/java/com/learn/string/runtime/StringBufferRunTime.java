package com.learn.string.runtime;

//���Դ���  40-45
public class StringBufferRunTime {
	public static void main(String[] args) {
		// �� ���Դ���λ��1
		String s1 = "Heart";
		StringBuffer sb = new StringBuffer();
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			// �� ���Դ���λ��2
			sb.append(s1);
		}
//		sb.toString();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}
}