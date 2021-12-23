package com.icia.dabyinsa.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.icia.dabyinsa.admin.dto.OrderListDto;

@Mapper
public interface OrderSearchDao {
	
	List<OrderListDto> getOList(String keyword, String keyword2, String searchOption, String searchOption2);
	int getOListCount(String keyword, String keyword2, String searchOption, String searchOption2);
}
