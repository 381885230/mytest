package com.demo.student;

import org.springframework.stereotype.Service;

import com.demo.aop.LogAnnotation;

@Service
public class StudentServiceImpl implements StudentService {

//	@MyAnnotation
    @LogAnnotation(moduleName="查询名字", operation = "测试")
	@Override
	public int getStuCount() {
    	System.out.println("进入getStuCount方法");
		return 100;
	}

}
