package com.icia.dabyinsa.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.icia.dabyinsa.user.dao.CartDao;
import com.icia.dabyinsa.user.dto.CartDto;

@Controller
@RequestMapping("/user/cart/*")
public class CartController {
	@Inject
	CartDao cartDao;
	
	@RequestMapping("delete.do")
	public String delete(int c_id) {
		cartDao.delete(c_id);
		return "redirect:/user/cart/list.do";
	}
	
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session) {
		String m_id=(String)session.getAttribute("m_id");
		if(m_id!=null) {
			cartDao.delete_all(m_id);
		}
		return "redirect:/user/cart/list.do";
	}
	
	@RequestMapping("update.do")
	public String update(int[] prod_ea, int[] c_id, HttpSession session) {
		String m_id=(String)session.getAttribute("m_id");
		if(m_id==null) {
			return "redirect:/user/loginForm.do";
		}
		for(int i=0; i<c_id.length; i++) {
			if(prod_ea[i]==0) {
				cartDao.delete(c_id[i]);
			}else {
				CartDto dto=new CartDto();
				dto.setM_id(m_id);
				dto.setC_id(c_id[i]);
				dto.setProd_ea(prod_ea[i]);
				cartDao.modify(dto);
			}
			
		}
		return "redirect:/user/cart/list.do";
		
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(HttpSession session, ModelAndView mav) {
		Map<String, Object> map=new HashMap<>();
		String m_id=(String)session.getAttribute("m_id");
		if(m_id!=null) {
			List<CartDto> list=cartDao.list(m_id);
			int sumMoney=cartDao.sum_money(m_id);
			int fee=sumMoney>=30000?0:2500;
			map.put("sumMoney", sumMoney);
			map.put("fee", fee);
			map.put("sum", sumMoney+fee);
			map.put("list", list);
			map.put("count", list.size());
			mav.setViewName("user/cart_list");
			mav.addObject("map",map);
			return mav;
		
		}else {
			return new ModelAndView("user/loginForm");
		}
		
	}
	
	@RequestMapping("insert.do")
	public String insert(CartDto dto, HttpSession session) {
		String m_id=(String)session.getAttribute("m_id");
		if(m_id==null) {
			return "redirect:/user/loginForm.do";
		}else
		dto.setM_id(m_id);
		cartDao.insert(dto);
		return "redirect:/user/cart/list.do";
	}
	
	    @RequestMapping(value = "order/buy/{m_id}",method = RequestMethod.POST)
	  private String buy(@PathVariable int m_id,OrderDto orderDto) {
	      try {
	        //insert
	        orderService.ordersInsertService(orderDto);
	        orderService.orderDetailInsertService(m_id);
	        orderService.cartDelete(m_id);
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	      return "order/ordercomplete";
	    }
	
	
}
