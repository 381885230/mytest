package com.yj.demo.service.impl;

import com.yj.demo.service.IDemoService;

public class DemoServiceImpl implements IDemoService {

	@Override
	public String getMyName(String name) {
		return "my name is "+name;
	}

	@Override
	public int add(Integer a, Integer b) {
		return a+b;
	}

}
