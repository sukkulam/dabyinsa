package com.icia.dabyinsa.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

	@GetMapping("/main")
	public String main() {
		return "admin/main";
	}

	// 전체주문목록
	@GetMapping("/adorderlist")
	public String adorderlist() {
		return "admin/order/adorderlist";
	}

	// 입금전
	@GetMapping("/adpaymentlist")
	public String adpaymentlist(){
		return "admin/delivery/adpaymentlist";
	}
	
	// 배송준비중
	@GetMapping("/adshippedbeginlist")
	public String adshippedbeginlist(){
		return "admin/delivery/adshippedbeginlist";
	}

	// 배송대기
	@GetMapping("/adshippedstandbylist")
	public String adshippedstandbylist(){
		return "admin/delivery/adshippedstandbylist";
	}
	
	
	// 배송중
	@GetMapping("/adshippedendlist")
	public String adshippedendlist() {
		return "admin/delivery/adshippedendlist";
	}
	
	// 배송완료
	@GetMapping("/adshippedcompletelist")
	public String adshippedcompletelist() {
		return "admin/delivery/adshippedcompletelist";
	}
	
	// 취소
	@GetMapping("/adordercancel")
	public String adordercancel() {
		return "admin/order/adordercancel";
	}
	
	// 교환
	@GetMapping("/adorderchange")
	public String adorderchange() {
		return "admin/order/adorderchange";
	}
	
	// 반품
	@GetMapping("/adorderreturns")
	public String adorderreturns() {
		return "admin/order/adorderreturns";
	}
	
	// 환불
	@GetMapping("/adordercashrefund")
	public String adordercashrefund() {
		return "admin/order/adordercashrefund";
	}
}
