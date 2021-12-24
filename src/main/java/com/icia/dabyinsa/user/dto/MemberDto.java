package com.icia.dabyinsa.user.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class MemberDto {
		public String m_id;
		public String m_pass;
		public String m_name;
		public String m_phone;
		public String m_email;
		public String enrolldate;
		public String deletedate;
		public int m_point;
		public String m_grade;
		public String m_provider;
		public String m_providerId;
		public int m_message;
		public String m_memo;
		public int m_postal;
		public String m_address;
		public String m_addr;
		public String m_role;
		
		public List<String> getRoleList(){
	        if(this.m_role.length() > 0){
	            return Arrays.asList(this.m_role.split(","));
	        }
	        return new ArrayList<>();
	    }
}

