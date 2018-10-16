package com.learn.aliruletest;

import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {

		String[] str = new String[] { "a", "b" }; 
		List list = Arrays.asList(str);
//		list.add("c");
		str[0]= "gujin";
		System.out.println(list);
		
	}

}
