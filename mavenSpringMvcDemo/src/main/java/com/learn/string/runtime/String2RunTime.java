package com.learn.string.runtime;

//测试代码  60-70ms左右
public class String2RunTime {
	public static void main(String[] args) {
		// ● 测试代码位置1
		String s1 = "Heart";
		String s2 = "Raid";
		String str = "";
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			// ● 测试代码位置2
			str = s1 + s2;
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}
}