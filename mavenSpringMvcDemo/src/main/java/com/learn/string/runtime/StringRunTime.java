package com.learn.string.runtime;

//测试代码  1-2ms
public class StringRunTime {
	public static void main(String[] args) {
		// ● 测试代码位置1
		String str = "";
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			// ● 测试代码位置2
			str = "Heart" + "Raid";
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}
}