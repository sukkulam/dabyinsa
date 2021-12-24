package com.icia.dabyinsa.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.dabyinsa.user.dao.MemberDao;
import com.icia.dabyinsa.user.dto.MemberDto;

import lombok.extern.java.Log;

@Service
@Log
public class MemberService {
	
	@Autowired
	private MemberDao mDao;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	ModelAndView mv;
	
	@Transactional
	public String memberInsert(MemberDto member, 
			RedirectAttributes rttr) {
		log.info("memberInsert()");
		String view = null;
		String msg = null;
		
		
		String rawPassword = member.getM_pass();// 비밀번호 원문
		String encPassword = encoder.encode(rawPassword); // 해쉬 값
		member.setM_pass(encPassword);
		
		try {
			mDao.memberInsert(member);	
			view = "redirect:/";
			msg = "가입 성공";
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:joinFrm";
			msg = "가입 실패";
		}
		
		rttr.addFlashAttribute("msg", msg);
		
		return view;
	}
	
	public String idCheck(String id) {
		String res = null;
		
		//아이디를 검색하여 중복 아이디가 있으면 1,
		//없으면 0이 넘어옴.
		int cnt = mDao.idCheck(id);
		if(cnt == 0) {
			res = "ok";
		}
		else {
			res = "fail";
		}
		
		return res;
	}
	
	public int orderBefore(int number) {
		
		return mDao.orderBefore(number);
	}
	
	public int payment(int number) {
		return mDao.payment(number);
		
	}
	
	public MemberDto login(String m_id) {
		MemberDto mDto = mDao.login(m_id);
		
		return mDto;
		
	}
	

	
		
	

}
