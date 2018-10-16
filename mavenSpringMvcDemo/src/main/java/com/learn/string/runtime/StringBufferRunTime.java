package com.learn.string.runtime;

//测试代码  40-45
public class StringBufferRunTime {
	public static void main(String[] args) {
		// ● 测试代码位置1
		String s1 = "Heart";
		StringBuffer sb = new StringBuffer();
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			// ● 测试代码位置2
			sb.append(s1);
		}
//		sb.toString();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}
}