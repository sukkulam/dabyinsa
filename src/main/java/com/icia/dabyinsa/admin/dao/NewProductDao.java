package com.icia.dabyinsa.admin.dao;

import org.apache.ibatis.annotations.Mapper;

import com.icia.dabyinsa.admin.dto.product.prodinfoDto;

@Mapper
public interface NewProductDao {
    
    public void NewProduct(prodinfoDto pi);
    
	public int Check(String ck);
}
