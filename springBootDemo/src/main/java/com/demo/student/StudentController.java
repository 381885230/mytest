package com.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.aop.LogAnnotation;

@RestController
@RequestMapping("/student")
public class StudentController{
	
	@Autowired
	StudentService studentServiceImpl;
	
    @RequestMapping(value = "/getName")
    @LogAnnotation(moduleName="查询名字", operation = "测试")
//    @MyAnnotation
    public String getName(@RequestParam(value="id")String id,@RequestParam(value="name")String name) {
    	System.out.println(id+"_"+name);
    	return id+name;
    }
    
    @RequestMapping(value = "/running")
    @LogAnnotation(moduleName="ctl运动", operation = "ctl跑步")
    public void running(){
    	System.out.println("go to running");
    	studentServiceImpl.running(10);
    }

}
