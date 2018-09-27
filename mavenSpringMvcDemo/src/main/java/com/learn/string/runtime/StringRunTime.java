package com.learn.string.runtime;

//²âÊÔ´úÂë  1-2ms
public class StringRunTime {
	public static void main(String[] args) {
		// ¡ñ ²âÊÔ´úÂëÎ»ÖÃ1
		String str = "";
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			// ¡ñ ²âÊÔ´úÂëÎ»ÖÃ2
			str = "Heart" + "Raid";
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}
}