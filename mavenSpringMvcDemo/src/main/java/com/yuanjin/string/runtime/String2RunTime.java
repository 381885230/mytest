package com.yuanjin.string.runtime;

//²âÊÔ´úÂë  60-70ms×óÓÒ
public class String2RunTime {
	public static void main(String[] args) {
		// ¡ñ ²âÊÔ´úÂëÎ»ÖÃ1
		String s1 = "Heart";
		String s2 = "Raid";
		String str = "";
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			// ¡ñ ²âÊÔ´úÂëÎ»ÖÃ2
			str = s1 + s2;
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}
}