package com.yuanjin.string.runtime;

//���Դ���  60-70ms����
public class String2RunTime {
	public static void main(String[] args) {
		// �� ���Դ���λ��1
		String s1 = "Heart";
		String s2 = "Raid";
		String str = "";
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			// �� ���Դ���λ��2
			str = s1 + s2;
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}
}