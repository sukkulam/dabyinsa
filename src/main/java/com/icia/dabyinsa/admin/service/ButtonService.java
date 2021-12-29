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
	
	// 배송중처리 버튼
	public void sStartBtn(String ocode) {
		bDao.setSStart(ocode);
	}
	
	// 배송준비중처리 버튼
	public void sBeginBtn(String ocode) {
		bDao.setSBegin(ocode);
	}
	
	// 배송대기중처리 버튼
	public void sStandByBtn(String ocode) {
		bDao.setSStandBy(ocode);
	}
	
	// 배송완료처리 버튼
	public void sEndBtn(String ocode) {
		bDao.setSEnd(ocode);
	}
}
