package com.demo.junittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Application;
import com.alibaba.fastjson.JSON;
import com.transaction.user.dao.CompanyDao;
import com.transaction.user.dao.UserDao;
import com.transaction.user.model.Company;
import com.transaction.user.model.User;
import com.transaction.user.service.UserService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class UserGenericTest {

	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CompanyDao companyDao;
	
	@Test
	public void test(){
		User user=(User)userService.getEntity(new User());
		Company comp=(Company)userService.getEntity(new Company());
		
		System.out.println(JSON.toJSONString(user));
		System.out.println(JSON.toJSONString(comp));

	}
	
}