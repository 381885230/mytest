package com.learn.list;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;


public class SublistTest {
	public static void main(String[] args) {
		List<String> sl=new ArrayList<>();
		sl.add("aa");
		sl.add("bb");
		sl.add("cc");
		sl.add("dd");
		sl.add("ee");
		sl.add("ff");
		
		List<String> s0=sl.subList(0, 1);
		List<String> s1=sl.subList(1, 3);
		List<String> s2=sl.subList(3, 6);
		System.out.println(JSON.toJSONString(s0));
		System.out.println(JSON.toJSONString(s1));
		System.out.println(JSON.toJSONString(s2));
		
		List<String> s3=new ArrayList<>();
		s3.addAll(s0);
		s3.addAll(s1);
		s3.addAll(s2);

		System.out.println(JSON.toJSONString(s3));

	}
}

