package com.icia.dabyinsa.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.icia.dabyinsa.user.dto.MemberDto;

@Mapper
public interface MemberDao {
	
	public MemberDto login(String m_id); 
	
	public void memberInsert(MemberDto member);
	
	public int idCheck(String id);
	
	public int orderBefore(int number);
	
	public int payment(int number);
	

}
