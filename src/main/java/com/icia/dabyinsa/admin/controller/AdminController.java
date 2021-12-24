package com.icia.dabyinsa.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.dabyinsa.admin.dto.OrderCancelDto;
import com.icia.dabyinsa.admin.dto.OrderListDto;
import com.icia.dabyinsa.admin.service.AdminService;

import lombok.extern.java.Log;

@Controller
@RequestMapping("admin")
@Log
public class AdminController {
	
	@Autowired
	private AdminService as;
	
	@GetMapping("/main")
	public String main() {
		return "admin/main";
	}

	// 전체주문목록
	@GetMapping("/adorderlist")
	public String adorderlist(Model model, 
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyword2,
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String searchOption2) {
		List<OrderListDto> oList = as.getOrderList(keyword, keyword2, searchOption, searchOption2);
		int count = as.getOrderListCount(keyword, keyword2, searchOption, searchOption2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("searchOption2", searchOption2);
		map.put("oList", oList);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("keywor2", keyword2);
		
		model.addAttribute("map", map);
		return "admin/order/adorderlist";
	}
	
	// 취소
	@GetMapping("/adordercancel")
	public String adordercancel(Model model,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyword2,
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String searchOption2) {
		log.info("keyword : "+keyword);
		List<OrderCancelDto> ocList = as.getOrderCList(keyword, keyword2, searchOption, searchOption2);
		int count = as.getOrderCListCount(keyword, keyword2, searchOption, searchOption2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("searchOption2", searchOption2);
		map.put("ocList", ocList);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("keywor2", keyword2);
		
		model.addAttribute("map", map);
		return "admin/order/adordercancel";
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
