package com.icia.dabyinsa.admin.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ButtonDao {
	
	// 반품 버튼
	void setReturns(String ocode);
	
	// 환불 버튼
	void setRefund(String ocode);
	
	// 입금확인 버튼
	void setPOk(String ocode);
	
	// 주문취소 버튼
	void setPCancle(String ocode);
}
