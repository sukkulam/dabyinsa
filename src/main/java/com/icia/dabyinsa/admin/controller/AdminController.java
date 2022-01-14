package com.icia.dabyinsa.admin.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.dabyinsa.admin.dto.delivery.PaymentListDto;
import com.icia.dabyinsa.admin.dto.delivery.ShippedBeginListDto;
import com.icia.dabyinsa.admin.dto.delivery.ShippedCompleteListDto;
import com.icia.dabyinsa.admin.dto.delivery.ShippedEndListDto;
import com.icia.dabyinsa.admin.dto.delivery.ShippedStandbyListDto;
import com.icia.dabyinsa.admin.dto.order.OrderCancelDto;
import com.icia.dabyinsa.admin.dto.order.OrderChangeDto;
import com.icia.dabyinsa.admin.dto.order.OrderListDto;
import com.icia.dabyinsa.admin.dto.order.OrderRefundDto;
import com.icia.dabyinsa.admin.dto.order.OrderReturnsDto;
import com.icia.dabyinsa.admin.dto.product.prodinfoDto;
import com.icia.dabyinsa.admin.dto.product.productlistDto;
import com.icia.dabyinsa.admin.service.AdminService;
import com.icia.dabyinsa.admin.service.ButtonService;
import com.icia.dabyinsa.user.dto.MemberDto;
import com.icia.dabyinsa.user.service.MemberService;

import lombok.extern.java.Log;

@Controller
@RequestMapping("admin")
@Log
public class AdminController {
	
	@Autowired
	private AdminService as;
	
	@Autowired
	private MemberService ms;
	
	@Autowired
	private ButtonService bs;


	@GetMapping("/main")
	public String main(Model model, Principal p) {
		MemberDto member = ms.login(p.getName());
		model.addAttribute("mb", member);
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
		log.info(keyword);
		log.info(keyword2);
		log.info(searchOption);
		log.info(searchOption2);
		System.out.println(oList);
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

	// 교환
	@GetMapping("/adorderchange")
	public String adorderchange(Model model,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyword2,
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String searchOption2) {
		List<OrderChangeDto> ocgList = as.getOrderCGList(keyword, keyword2, searchOption, searchOption2);
		int count = as.getOrderCGListCount(keyword, keyword2, searchOption, searchOption2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("searchOption2", searchOption2);
		map.put("ocgList", ocgList);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("keywor2", keyword2);
		
		model.addAttribute("map", map);
		return "admin/order/adorderchange";
	}
	
	// 환불
	@GetMapping("/adordercashrefund")
	public String adordercashrefund(Model model,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyword2,
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String searchOption2) {
		List<OrderRefundDto> orList = as.getOrderRList(keyword, keyword2, searchOption, searchOption2);
		int count = as.getOrderRListCount(keyword, keyword2, searchOption, searchOption2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("searchOption2", searchOption2);
		map.put("orList", orList);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("keywor2", keyword2);
		
		model.addAttribute("map", map);
		return "admin/order/adordercashrefund";
	}
	
	// 반품
	@GetMapping("/adorderreturns")
	public String adorderreturns(Model model,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyword2,
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String searchOption2) {
		List<OrderReturnsDto> ortList = as.getOrderRTList(keyword, keyword2, searchOption, searchOption2);
		int count = as.getOrderRTListCount(keyword, keyword2, searchOption, searchOption2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("searchOption2", searchOption2);
		map.put("ortList", ortList);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("keywor2", keyword2);
		
		model.addAttribute("map", map);
		return "admin/order/adorderreturns";
	}
	
	// 입금전
	@GetMapping("/adpaymentlist")
	public String adpaymentlist(Model model,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyword2,
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String searchOption2) {
		List<PaymentListDto> pList = as.getPList(keyword, keyword2, searchOption, searchOption2);
		int count = as.getPListCount(keyword, keyword2, searchOption, searchOption2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("searchOption2", searchOption2);
		map.put("pList", pList);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("keywor2", keyword2);
		
		model.addAttribute("map", map);
		return "admin/delivery/adpaymentlist";
	}
	
	// 배송준비중
	@GetMapping("/adshippedbeginlist")
	public String adshippedbeginlist(Model model,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyword2,
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String searchOption2) {
		List<ShippedBeginListDto> sbList = as.getSBList(keyword, keyword2, searchOption, searchOption2);
		int count = as.getSBListCount(keyword, keyword2, searchOption, searchOption2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("searchOption2", searchOption2);
		map.put("sbList", sbList);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("keywor2", keyword2);
		
		model.addAttribute("map", map);
		return "admin/delivery/adshippedbeginlist";
	}

	// 배송대기
	@GetMapping("/adshippedstandbylist")
	public String adshippedstandbylist(Model model,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyword2,
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String searchOption2) {
		List<ShippedStandbyListDto> ssList = as.getSSList(keyword, keyword2, searchOption, searchOption2);
		int count = as.getSSListCount(keyword, keyword2, searchOption, searchOption2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("searchOption2", searchOption2);
		map.put("ssList", ssList);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("keywor2", keyword2);
		
		model.addAttribute("map", map);
		return "admin/delivery/adshippedstandbylist";
	}
	
	
	// 배송중
	@GetMapping("/adshippedendlist")
	public String adshippedendlist(Model model,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyword2,
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String searchOption2) {
		List<ShippedEndListDto> seList = as.getSEList(keyword, keyword2, searchOption, searchOption2);
		int count = as.getSEListCount(keyword, keyword2, searchOption, searchOption2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("searchOption2", searchOption2);
		map.put("seList", seList);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("keywor2", keyword2);
		
		model.addAttribute("map", map);
		return "admin/delivery/adshippedendlist";
	}
	
	// 배송완료
	@GetMapping("/adshippedcompletelist")
	public String adshippedcompletelist(Model model,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String keyword2,
			@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String searchOption2) {
		List<ShippedCompleteListDto> scList = as.getSCList(keyword, keyword2, searchOption, searchOption2);
		int count = as.getSCListCount(keyword, keyword2, searchOption, searchOption2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("searchOption2", searchOption2);
		map.put("scList", scList);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("keywor2", keyword2);
		
		model.addAttribute("map", map);
		return "admin/delivery/adshippedcompletelist";
	}
	

	// 상품 등록 페이지
	@PostMapping("/setnewproduct")
	public String setNewProduct(prodinfoDto pi,
			RedirectAttributes rttr, MultipartHttpServletRequest multi) throws Exception {

		
			System.out.println(pi);
			
		String view = as.NewProduct(pi, rttr, multi);	//첫번째 메퍼쿼리가 실행되도록 pi를 윗 순서로 배치
		as.fileUpload(multi, pi.getProd_id_seq());		//파일 업로드 까지 완료
		
		//return view;
		return "admin/product/newproduct";
	}

	

	@GetMapping("/newproduct")
	public String newproduct() {
		
		return "admin/product/newproduct";
	}

	// 상품목록 페이지
	@GetMapping("/productlist")
	public String productlist(Model model,
			@RequestParam(defaultValue = "") String plkeyword,
			@RequestParam(defaultValue = "") String plkeyword2,
			@RequestParam(defaultValue = "all") String plsearchOption,
			@RequestParam(defaultValue = "") String plsearchOption2) {
		List<productlistDto> plList = as.getPLList(plkeyword, plkeyword2, plsearchOption, plsearchOption2);

		int count = as.getPLListCount(plkeyword, plkeyword2, plsearchOption, plsearchOption2);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", plsearchOption);
		map.put("plList", plList);
		map.put("count", count);
		map.put("keyword", plkeyword);
		map.put("keywor2", plkeyword2);

		model.addAttribute("map", map);
		return "admin/product/productlist";

	}

	// 미리보기 페이지
	@GetMapping("/preview")
	public String preview() {
		return "admin/product/preview";

	}

	// 상품 불러오기 페이지
	@GetMapping("/productload")
	public String productload() {
		return "admin/product/productload";
	}
	//중복체크
	@PostMapping(value = "Check",
			produces = "application/text; charset=utf-8")
	@ResponseBody
	public String Check(String admin_prod_code) {
		
		//이후 해당 아이디로 DB를 검색하는 서비스와 Dao를 활용.
		String res = as.Check(admin_prod_code);
		
		return res;
	}


	//게시물 삭제
	@GetMapping("/pdelete")
	public String postdelete(String pid) throws Exception {
		bs.pdelete(pid);
		
		return "redirect:productlist";
	}
	
	
	//상품 선택 삭제
	@PostMapping("/pdelete")
	public String delete(HttpServletRequest request) throws Exception{
		
		String[] ajaxMsg = request.getParameterValues("valueArr");
		System.out.println("ajaxMsg : " + ajaxMsg[0]);
		int size = ajaxMsg.length;
		for(int i=0; i<size; i++ ) {
			System.out.println(ajaxMsg[i]);
		bs.pdelete(ajaxMsg[i]);
		}
		return "redirect:productlist";		
}
	
	
}

