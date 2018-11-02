package com.yj.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yj.demo.service.IDemoService;
import com.yj.mvcframework.annotation.MyAutowired;
import com.yj.mvcframework.annotation.MyController;
import com.yj.mvcframework.annotation.MyRequestMapping;
import com.yj.mvcframework.annotation.MyRequestParam;

@MyController
@MyRequestMapping("/demo")
public class DemoController {
	@MyAutowired
	private IDemoService demoService;

	@MyRequestMapping("/getMyName")
	public void getMyName(HttpServletRequest req, HttpServletResponse resp, @MyRequestParam("name") String name) {
		String result = demoService.getMyName(name);
		try {
			resp.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@MyRequestMapping("/test")
	public void test(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.getWriter().write("11111111");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	@MyRequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp, @MyRequestParam("a") Integer a, @MyRequestParam("b") Integer b){
		Integer result = demoService.add(a,b);
		try {
			resp.getWriter().write(String.valueOf(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
