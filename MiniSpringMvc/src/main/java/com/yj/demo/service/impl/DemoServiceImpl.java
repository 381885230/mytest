package com.yj.demo.service.impl;

import com.yj.demo.service.IDemoService;
import com.yj.mvcframework.annotation.MyService;

@MyService
public class DemoServiceImpl implements IDemoService {

	@Override
	public String getMyName(String name) {
		return "my name is "+name;
	}

	@Override
	public Integer add(Integer a, Integer b) {
		Integer c=a+b;
		return c;
	}

}