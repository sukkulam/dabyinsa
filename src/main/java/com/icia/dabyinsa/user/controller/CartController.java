package com.icia.dabyinsa.user.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.dabyinsa.user.dao.CartDao;
import com.icia.dabyinsa.user.dto.CartDto;

@Controller
@RequestMapping("/user/cart/*")
public class CartController {
	@Autowired
	CartDao cartDao;
	
	
	
	@RequestMapping("delete")
	public String delete(int cart_id) {
		cartDao.delete(cart_id);
		return "redirect:/user/cart/list";
	}
	
	@RequestMapping("deleteAll")
	public String deleteAll(HttpSession session, Principal p) {
		//String m_id=(String)session.getAttribute("m_id");
		String m_id= p.getName();
		if(m_id!=null) {
			cartDao.delete_all(m_id);
		}
		return "redirect:/user/cart/list";
	}
	
	@RequestMapping("update")
	public String update(int[] amount, int[] cart_id, HttpSession session, Principal p) {
		//String m_id=(String)session.getAttribute("m_id");
		String m_id= p.getName();
		for(int i=0; i<cart_id.length; i++) {
			if(amount[i]==0) {
				cartDao.delete(cart_id[i]);
			}else {
				CartDto dto=new CartDto();
				dto.setM_id(m_id);
				dto.setCart_id(cart_id[i]);
				dto.setAmount(amount[i]);
				cartDao.update(dto);
			}
		
		}
		return "redirect:/user/cart/list";
	}
	
	@RequestMapping("list")
	public ModelAndView list(HttpSession session, ModelAndView mav, Principal p) {
		Map<String, Object> map=new HashMap<>();
		//String m_id=(String)session.getAttribute("m_id");
		String m_id= p.getName();
		if(m_id!=null) {
			List<CartDto> list=cartDao.list(m_id);
			int sumMoney=cartDao.sum_money(m_id);
			int fee=sumMoney>=30000?0:3000;
			map.put("sumMoney", sumMoney);
			map.put("fee", fee);
			map.put("sum", sumMoney+fee);
			map.put("list", list);
			map.put("count", list.size());
			mav.setViewName("user/cart_list");
			mav.addObject("map", map);
			return mav;
		}else {
			mav.setViewName("redirect:loginForm");
			mav.addObject("map", map);
			return mav;
		}
	}
	
	@RequestMapping("cinsert")
	public String insert(String[] chk, Principal p) {
		System.out.println(chk);
		//String m_id=(String)session.getAttribute("m_id");
		String m_id= p.getName();
		if(m_id==null) {
			return "redirect:/user/login";
		}
		for(String s : chk) {
			CartDto c = new CartDto();
			c.setM_id(m_id);
			c.setProd_id(s);
			cartDao.cinsert(c);
		}
//		dto.setM_id(m_id);
//		cartDao.cinsert(dto);
		return "redirect:/user/cart/list";
	}
	
	@RequestMapping("cainsert")
	public String cainsert(CartDto dto, HttpSession session, Principal p) {
		//String m_id=(String)session.getAttribute("m_id");
		String m_id= p.getName();
		if(m_id==null) {
			return "redirect:/user/login";
		}
		dto.setM_id(m_id);
		cartDao.cainsert(dto);
		return "redirect:/user/cart/list";
	}
	
	
	/*
	@RequestMapping("orderInsert")
	public String orderInsert(CartDto dto, HttpSession session, Principal p) {
		//String m_id=(String)session.getAttribute("m_id");
		String m_id= p.getName();
		if(m_id==null) {
			return "redirect:/user/login";
		}
		dto.setM_id(m_id);
		cartDao.cainsert(dto);
		return "redirect:/user/cart/List";
	}
	*/
	

	
	/*
	 @PostMapping("/cartList")
	 public String order(HttpSession session, OrderDto order, @RequestParam(value = "chk[]") List<String> chArr) throws Exception {
	  logger.info("order");
	  
	  String userId = (String)session.getAttribute("member");  
	  
      //주문번호(orderId) 생성을 위한 로직
	  Calendar cal = Calendar.getInstance();
	  int year = cal.get(Calendar.YEAR);
	  String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
	  String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
	  String subNum = "";
	  
	  for(int i = 1; i <= 6; i ++) {
	   subNum += (int)(Math.random() * 10);
	  }
	  
	  String orderId = ymd + "_" + subNum; //ex) 20200508_373063
	  order.setOrderId(orderId);
	  order.setUserId(userId);
	  
	  service.orderInfo(order); //주문 테이블 insert
	  
	  int cartNum = 0;
	  for(String i : chArr){
		  cartNum = Integer.parseInt(i);
		  System.out.println("cart -> CHK orderList : "+cartNum);
		  System.out.println("cart -> orderId orderList : "+orderId);
		  service.orderInfoDetails(orderId,cartNum); //주문 상세 테이블 insert
		  service.cartDelete(cartNum); //체크되어 들어온 cart번호로 cart table delete
	  }
	  
	  
	  return "redirect:/shop/myPage";  
	 }
	
*/
	/*
	   @RequestMapping(value = "order/buy/{m_id}",method = RequestMethod.POST)
		  private String orderGo(@PathVariable int m_id,OrderDto orderDto) {
		      try {
		        orderService.ordersInsertService(orderDto);
		        orderService.orderDetailInsertService(m_id);
		        orderService.cartDelete(m_id);
		    } catch (Exception e) {
		       e.printStackTrace();
		    }
		      return "order/ordercomplete";
		    }
		*/
}
	
