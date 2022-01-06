package com.icia.dabyinsa.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icia.dabyinsa.admin.service.ButtonService;

@RestController
@RequestMapping("admin")
public class AdminApiController {

	@Autowired
	private ButtonService bs;

	// 반품 버튼
	@PutMapping("/api/returns")
	public ResponseEntity<Integer> returns(String ocode) {
		bs.returnsBtn(ocode);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	// 환불 버튼
	@PutMapping("/api/refund")
	public ResponseEntity<Integer> refund(String ocode) {
		bs.refundBtn(ocode);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	// 입금 확인버튼
	@PutMapping("/api/pOk")
	public ResponseEntity<Integer> pOk(String ocode) {
		bs.pOkBtn(ocode);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	// 주문취소 버튼
	@PutMapping("/api/pCancle")
	public ResponseEntity<Integer> pCancle(String ocode) {
		bs.pCancleBtn(ocode);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	
	// 배송중처리 버튼
	@PutMapping("/api/sStart")
	public ResponseEntity<Integer> sStart(String ocode) {
		bs.sStartBtn(ocode);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	
	// 배송준비중처리 버튼
	@PutMapping("/api/sBegin")
	public ResponseEntity<Integer> sBegin(String ocode) {
		bs.sBeginBtn(ocode);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	
	// 배송대기중처리 버튼
	@PutMapping("/api/sStandBy")
	public ResponseEntity<Integer> sStandBy(String ocode) {
		bs.sStandByBtn(ocode);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	
	// 배송완료처리 버튼
	@PutMapping("/api/sEnd")
	public ResponseEntity<Integer> sEnd(String ocode) {
		bs.sEndBtn(ocode);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
}
