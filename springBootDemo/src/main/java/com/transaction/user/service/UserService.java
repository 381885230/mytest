package com.transaction.user.service;

import com.transaction.user.model.User;

public interface UserService<T> {
	
	public User getNameById(User user);
	
	public void update1();
	
	public void update2();

	public T getEntity(T t);

}
