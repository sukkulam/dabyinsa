package com.icia.dabyinsa.admin.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ButtonDao {
	
	void setReturns(String ocode);
}
