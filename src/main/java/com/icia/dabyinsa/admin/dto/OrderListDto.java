package com.icia.dabyinsa.admin.dto;

import lombok.Data;

@Data
public class OrderListDto {
	
	String odate;
	String ocode;
	String mid;
	String prodname;
	int ppay;
	int pstatus;
	int dstatus;
	int oitotalprice;

}
