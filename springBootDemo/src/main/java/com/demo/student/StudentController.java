package com.demo.student;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController{
	
    @RequestMapping(value = "/getName")
    public String getName(@RequestParam(value="id")String id,@RequestParam(value="name")String name) {
    	System.out.println(id+"_"+name);
    	return id+name;
    }

}
