package com.transaction.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.user.dao.UserDao;
import com.transaction.user.model.User;
import com.transaction.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getNameById(User user) {
		return userDao.getNameById(user);
	}
	
	

}
