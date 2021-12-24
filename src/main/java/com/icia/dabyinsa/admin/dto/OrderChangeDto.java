package com.icia.dabyinsa.admin.dto;

import lombok.Data;

@Data
public class OrderChangeDto {
	
	String acceptdate;
	String ocode;
	String mid;
	String prodname;
	int oiamount;
	int procstatus;
	String memocontent;
}
