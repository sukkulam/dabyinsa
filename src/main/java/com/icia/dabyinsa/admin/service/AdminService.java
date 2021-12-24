package com.icia.dabyinsa.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.dabyinsa.admin.dao.OrderSearchDao;
import com.icia.dabyinsa.admin.dto.OrderCancelDto;
import com.icia.dabyinsa.admin.dto.OrderChangeDto;
import com.icia.dabyinsa.admin.dto.OrderListDto;

@Service
public class AdminService {
	
	@Autowired
	private OrderSearchDao osDao;
	
	// 전체 주문 목록
	public List<OrderListDto> getOrderList(String keyword, String keyword2, String searchOption, String searchOption2) {
		
		return osDao.getOList(keyword, keyword2, searchOption, searchOption2); 
	}
	
	public int getOrderListCount(String keyword, String keyword2, String searchOption, String searchOption2) {
		
		return osDao.getOListCount(keyword, keyword2, searchOption, searchOption2);
	}
	
	// 취소
	public List<OrderCancelDto> getOrderCList(String keyword, String keyword2, String searchOption, String searchOption2) {
		
		return osDao.getOCList(keyword, keyword2, searchOption, searchOption2);
	}
	
	public int getOrderCListCount(String keyword, String keyword2, String searchOption, String searchOption2) {
		
		return osDao.getOCListCount(keyword, keyword2, searchOption, searchOption2);
	}
	
	// 교환
	public List<OrderChangeDto> getOrderCGList(String keyword, String keyword2, String searchOption, String searchOption2) {
		
		return osDao.getOCGList(keyword, keyword2, searchOption, searchOption2);
	}
	
	public int getOrderCGListCount(String keyword, String keyword2, String searchOption, String searchOption2) {
		
		return osDao.getOCGListCount(keyword, keyword2, searchOption, searchOption2);
	}
}
