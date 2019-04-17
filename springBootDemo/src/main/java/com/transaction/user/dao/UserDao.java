package com.transaction.user.dao;

import org.apache.ibatis.annotations.Mapper;
import com.transaction.user.model.User;

@Mapper
public interface UserDao {
	
	public User getNameById(User user);

	public void updateById(User user);
	

}
