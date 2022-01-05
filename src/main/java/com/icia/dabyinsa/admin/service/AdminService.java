package com.icia.dabyinsa.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.dabyinsa.admin.dao.NewProductDao;
import com.icia.dabyinsa.admin.dao.OrderSearchDao;
import com.icia.dabyinsa.admin.dao.ProductSearchDao;
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

import lombok.extern.java.Log;

@Log
@Service
public class AdminService {

	@Autowired
	private OrderSearchDao osDao;
	
	@Autowired
	private ProductSearchDao psDao;
	
	@Autowired
	private NewProductDao npDao;

	ModelAndView mv;

	// 전체 주문 목록
	public List<OrderListDto> getOrderList(String keyword, String keyword2, String searchOption, String searchOption2) {

		return osDao.getOList(keyword, keyword2, searchOption, searchOption2);
	}

	public int getOrderListCount(String keyword, String keyword2, String searchOption, String searchOption2) {

		return osDao.getOListCount(keyword, keyword2, searchOption, searchOption2);
	}

	// 취소
	public List<OrderCancelDto> getOrderCList(String keyword, String keyword2, String searchOption,
			String searchOption2) {

		return osDao.getOCList(keyword, keyword2, searchOption, searchOption2);
	}

	public int getOrderCListCount(String keyword, String keyword2, String searchOption, String searchOption2) {

		return osDao.getOCListCount(keyword, keyword2, searchOption, searchOption2);
	}

	// 교환
	public List<OrderChangeDto> getOrderCGList(String keyword, String keyword2, String searchOption,
			String searchOption2) {

		return osDao.getOCGList(keyword, keyword2, searchOption, searchOption2);
	}

	public int getOrderCGListCount(String keyword, String keyword2, String searchOption, String searchOption2) {

		return osDao.getOCGListCount(keyword, keyword2, searchOption, searchOption2);
	}

	// 환불
	public List<OrderRefundDto> getOrderRList(String keyword, String keyword2, String searchOption,
			String searchOption2) {

		return osDao.getORList(keyword, keyword2, searchOption, searchOption2);
	}

	public int getOrderRListCount(String keyword, String keyword2, String searchOption, String searchOption2) {

		return osDao.getORListCount(keyword, keyword2, searchOption, searchOption2);
	}

	// 반품
	public List<OrderReturnsDto> getOrderRTList(String keyword, String keyword2, String searchOption,
			String searchOption2) {

		return osDao.getORTList(keyword, keyword2, searchOption, searchOption2);
	}

	public int getOrderRTListCount(String keyword, String keyword2, String searchOption, String searchOption2) {

		return osDao.getORTListCount(keyword, keyword2, searchOption, searchOption2);
	}

	// 입금전
	public List<PaymentListDto> getPList(String keyword, String keyword2, String searchOption,
			String searchOption2) {

		return osDao.getPList(keyword, keyword2, searchOption, searchOption2);
	}

	public int getPListCount(String keyword, String keyword2, String searchOption, String searchOption2) {

		return osDao.getPListCount(keyword, keyword2, searchOption, searchOption2);
	}
	
	// 배송준비중
	public List<ShippedBeginListDto> getSBList(String keyword, String keyword2, String searchOption,
			String searchOption2) {

		return osDao.getSBList(keyword, keyword2, searchOption, searchOption2);
	}

	public int getSBListCount(String keyword, String keyword2, String searchOption, String searchOption2) {

		return osDao.getSBListCount(keyword, keyword2, searchOption, searchOption2);
	}
	
	// 배송대기
	public List<ShippedStandbyListDto> getSSList(String keyword, String keyword2, String searchOption,
			String searchOption2) {

		return osDao.getSSList(keyword, keyword2, searchOption, searchOption2);
	}

	public int getSSListCount(String keyword, String keyword2, String searchOption, String searchOption2) {

		return osDao.getSSListCount(keyword, keyword2, searchOption, searchOption2);
	}
	
	// 배송중
	public List<ShippedEndListDto> getSEList(String keyword, String keyword2, String searchOption,
			String searchOption2) {

		return osDao.getSEList(keyword, keyword2, searchOption, searchOption2);
	}

	public int getSEListCount(String keyword, String keyword2, String searchOption, String searchOption2) {

		return osDao.getSEListCount(keyword, keyword2, searchOption, searchOption2);
	}
	
	// 배송완료
	public List<ShippedCompleteListDto> getSCList(String keyword, String keyword2, String searchOption,
			String searchOption2) {

		return osDao.getSCList(keyword, keyword2, searchOption, searchOption2);
	}

	public int getSCListCount(String keyword, String keyword2, String searchOption, String searchOption2) {

		return osDao.getSCListCount(keyword, keyword2, searchOption, searchOption2);
	}
	
	//상품 목록
	public List<productlistDto> getPLList(String plkeyword, String plkeyword2, String plsearchOption, String plsearchOption2) {

		return psDao.getPLList(plkeyword, plkeyword2, plsearchOption, plsearchOption2);
	}
	public int getPLListCount(String plkeyword, String plkeyword2, String plsearchOption, String plsearchOption2) {
		return psDao.getPLListCount(plkeyword, plkeyword2, plsearchOption, plsearchOption2);
	}
	//상품 등록

	@Transactional
	public String NewProduct(prodinfoDto pi, 
			RedirectAttributes rttr) {
		log.info("NewProduct()");
		String view = null;
		String msg = null;

		
		try {
			npDao.NewProduct(pi);	
			view = "redirect:/";
			msg = "등록 성공 ";
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:newproduct";
			msg = "등록 실패";
		}
		
		rttr.addFlashAttribute("msg", msg);
		
		return view;
	}
	public String Check(String ck) {
		String res = null;
		
		//코드를 검색하여 중복된 코드가 있으면 1,
		//없으면 0이 넘어옴.
		int cnt = npDao.Check(ck);
		if(cnt == 0) {
			res = "ok";
		}
		else {
			res = "fail";
		}
		
		return res;
	}
	

	
	
}
