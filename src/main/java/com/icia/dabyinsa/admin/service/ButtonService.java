package com.icia.dabyinsa.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.dabyinsa.admin.dao.ButtonDao;

@Service
public class ButtonService {
	
	@Autowired
	private ButtonDao bDao;
	
	// 반품 버튼
	public void returnsBtn(String ocode) {
		bDao.setReturns(ocode);
	}
	
	// 환불 버튼
	public void refundBtn(String ocode) {
		bDao.setRefund(ocode);
	}
	
	// 입금확인 버튼
	public void pOkBtn(String ocode) {
		bDao.setPOk(ocode);
	}
	
	// 주문취소 버튼
	public void pCancleBtn(String ocode) {
		bDao.setPCancle(ocode);
	}
}
