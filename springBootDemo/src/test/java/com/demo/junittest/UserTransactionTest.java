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
public class UserTransactionTest {

	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CompanyDao companyDao;
	
	/**
	 * 事务测试
	 */
	@Test
	public void testTransaction(){
		userService.update1();
	}
	
	@Test
	public void test(){
		User user=new User();
		user.setId("4");
		try {
			user=userService.getNameById(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(JSON.toJSONString(user));
	}
	
	@Test
	public void testUserUpdate(){
		User user=new User();
		user.setId("4");
		user.setUserName("haha");
		userDao.updateById(user);
	}
	
	@Test
	public void testCompUpdate(){
		Company comp=new Company();
		comp.setId("4");
		comp.setName("jd");
		companyDao.updateById(comp);
	}
	
}