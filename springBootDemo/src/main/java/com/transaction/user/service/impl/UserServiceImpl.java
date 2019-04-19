package com.transaction.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.user.dao.CompanyDao;
import com.transaction.user.dao.UserDao;
import com.transaction.user.model.Company;
import com.transaction.user.model.User;
import com.transaction.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	ApplicationContext context;
	
	
	@Override
	public User getNameById(User user) {
		return userDao.getNameById(user);
	}
	
//	@Transactional
	public void update1(){
		User user=new User();
		user.setId("1");
		user.setUserName("慌什么");
		Company comp=new Company();
		comp.setId("1");
		comp.setName("wahaha");
		
		userDao.updateById(user);
//		int a=1/0;
		companyDao.updateById(comp);
		
		update2();//无事务，不可回滚
//		context.getBean(UserServiceImpl.class).update2();//有事务，可回滚
	}


	@Transactional
	public void update2() {
		User user=new User();
		user.setId("2");
		user.setUserName("什么");
		Company comp=new Company();
		comp.setId("2");
		comp.setName("我是谁");
		
		userDao.updateById(user);
		int b=1/0;//抛出异常触发回滚
		companyDao.updateById(comp);		
	}

	@Override
	public Object getEntity(Object t) {
		if(t instanceof User){
			return userDao.getNameById((User)t);
		}else{
			return companyDao.getNameById((Company)t);
		}
	}
}
