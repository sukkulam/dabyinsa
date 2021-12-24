package com.icia.dabyinsa.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.icia.dabyinsa.admin.dto.OrderCancelDto;
import com.icia.dabyinsa.admin.dto.OrderChangeDto;
import com.icia.dabyinsa.admin.dto.OrderListDto;

@Mapper
public interface OrderSearchDao {
	
	// 전체 주문 목록
	List<OrderListDto> getOList(String keyword, String keyword2, String searchOption, String searchOption2);
	int getOListCount(String keyword, String keyword2, String searchOption, String searchOption2);
	
	// 취소
	List<OrderCancelDto> getOCList(String keyword, String keyword2, String searchOption, String searchOption2);
	int getOCListCount(String keyword, String keyword2, String searchOption, String searchOption2);
	
	// 교환
	List<OrderChangeDto> getOCGList(String keyword, String keyword2, String searchOption, String searchOption2);
	int getOCGListCount(String keyword, String keyword2, String searchOption, String searchOption2);
}
