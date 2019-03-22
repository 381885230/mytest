package com.demo.junittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.Application;
import com.demo.student.StudentService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class StuServiceTest {
    @Autowired
    private StudentService studentServiceImpl;
    
    
    @Test
    public void getCount() {
    	System.out.println(studentServiceImpl.getStuCount());
    }
    
    
    @Test
    public void testRun(){
    	studentServiceImpl.running(20);
    }
}