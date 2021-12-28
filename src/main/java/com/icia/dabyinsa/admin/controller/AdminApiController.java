package com.icia.dabyinsa.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icia.dabyinsa.admin.service.ButtonService;

@RestController
@RequestMapping("admin")
public class AdminApiController {
	
	@Autowired
	private ButtonService bs;
	
	// 반품 버튼
	@GetMapping("/api/returns")
	public ResponseEntity<Integer> returns(String ocode){
		bs.returnsBtn(ocode);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	
	// 환불 버튼
	@GetMapping("/api/refund")
	public ResponseEntity<Integer> refund(String ocode){
		bs.refundBtn(ocode);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
}
