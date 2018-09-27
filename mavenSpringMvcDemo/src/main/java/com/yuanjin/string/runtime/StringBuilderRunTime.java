package com.yuanjin.string.runtime;

//²âÊÔ´úÂë  20-25
public class StringBuilderRunTime {
	public static void main(String[] args) {
		// ¡ñ ²âÊÔ´úÂëÎ»ÖÃ1
		String s1 = "Heart";
		StringBuilder sb = new StringBuilder();
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			// ¡ñ ²âÊÔ´úÂëÎ»ÖÃ2
			sb.append(s1);
		}
//		sb.toString();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}
}