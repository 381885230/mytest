package com.learn.list;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;


public class SublistTest {
	public static void main(String[] args) {
		
		List<String> list=new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		list.add("ee");
		list.add("ff");
		
		List<String> s0=list.subList(0, 1);
		List<String> s1=list.subList(1, 3);
		List<String> s2=list.subList(3, 6);
		System.out.println(JSON.toJSONString(s0));
		System.out.println(JSON.toJSONString(s1));
		System.out.println(JSON.toJSONString(s2));
		
<<<<<<< HEAD
		System.out.println(list.contains("aa"));
		System.out.println(list.contains("aax"));
		System.out.println(list.containsAll(s0));
		
		List<String> s3=new ArrayList<>();
		s3.add("aa");
		s3.add("xx");
		System.out.println(list.containsAll(s3));
	
=======
		List<String> s3=new ArrayList<>();
		s3.addAll(s0);
		s3.addAll(s1);
		s3.addAll(s2);

		System.out.println(JSON.toJSONString(s3));

>>>>>>> branch 'master' of https://github.com/381885230/mytest.git
	}
}

