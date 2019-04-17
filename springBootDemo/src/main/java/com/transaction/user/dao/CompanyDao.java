package com.transaction.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.transaction.user.model.Company;

@Mapper
public interface CompanyDao {
	
	public Company getNameById(Company comp);

	public void updateById(Company comp);
	

}
