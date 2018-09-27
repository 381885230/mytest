package com.yuanjin.string;

public class Reverse {

	public static void main(String[] args) {
		String s=reverse("123");
		System.out.println(s);
	}
	
	public static String reverse(String originStr) {
		if(originStr == null || originStr.length() <= 1) 
			return originStr;
		return reverse(originStr.substring(1)) + originStr.charAt(0);
	}


}
