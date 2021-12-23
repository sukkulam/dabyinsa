package com.icia.dabyinsa.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.dabyinsa.admin.dao.OrderSearchDao;
import com.icia.dabyinsa.admin.dto.OrderListDto;

@Service
public class AdminService {
	
	@Autowired
	private OrderSearchDao osDao;
	
	
	public List<OrderListDto> getOrderList(String keyword, String keyword2, String searchOption, String searchOption2) {
		
		return osDao.getOList(keyword, keyword2, searchOption, searchOption2); 
	}
	
	public int getOrderListCount(String keyword, String keyword2, String searchOption, String searchOption2) {
		
		return osDao.getOListCount(keyword, keyword2, searchOption, searchOption2);
	}
}
