package com.icia.dabyinsa.user.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.dabyinsa.user.dao.MemberDao;
import com.icia.dabyinsa.user.dto.MemberDto;
import com.icia.dabyinsa.user.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mServ;

	@Autowired
	MemberDao mDao;
	
	@GetMapping("/loginForm")
	public String loginForm() {
		
		return "user/loginForm";
	}
	
	@GetMapping("joinFrm")
	public String joinFrm() {
		
		return "user/joinFrm";
	}
	
	@PostMapping("memInsert")
	public String memberInsert(MemberDto member,
			RedirectAttributes rttr) {
		
		String view = mServ.memberInsert(member, rttr);
		System.out.println(member);
		return view;
	}
	
	@GetMapping("findId")
	public String findId() {
		
		return "user/findId";
	}
	
	@GetMapping("findPw")
	public String findPw() {
		
		return "user/findPw";
	}
	
	@GetMapping("infoUpdatePage")
	public String infoUpdatePage(Model model, HttpSession session, Principal p) {
//		String m_id = (String) session.getAttribute("m_id");
		
		String m_id = p.getName();
		MemberDto mDto = mServ.login(m_id);
		
		model.addAttribute("mDto", mDto);

		
		return "user/infoUpdatePage";
	}
	
	
	@GetMapping("myPage")
	public String myPage(Model model) {

		int count = mServ.orderBefore(1);
		int count1 = mServ.orderBefore(2);
		int count2 = mServ.orderBefore(3);
		int count3 = mServ.orderBefore(4);
		int count4 = mServ.orderBefore(5);
		int count5 = mServ.orderBefore(6);
		int count6 = mServ.payment(0);
		int count7 = mServ.payment(1);
		
		
		//배송전
		model.addAttribute("orderBefore", count);
		//배송중
		model.addAttribute("ordering", count1);
		//배송완료
		model.addAttribute("orderComplete", count2);
		//취소
		model.addAttribute("ordercancle", count3);
		//교환
		model.addAttribute("orderChange", count4);
		//반품
		model.addAttribute("ordereturn", count5);
		//결제 전
		model.addAttribute("payBefore", count6);
		//결제 완료
		model.addAttribute("payAfter", count7);
		
		
		return "user/myPage";
	}
	
	@GetMapping(value = "idCheck",
			produces = "application/text; charset=utf-8")
	@ResponseBody
	public String idCheck(String mid) {
		
		//이후 해당 아이디로 DB를 검색하는 서비스와 Dao를 활용.
		String res = mServ.idCheck(mid);
		
		return res;
	}
	
	
	

}