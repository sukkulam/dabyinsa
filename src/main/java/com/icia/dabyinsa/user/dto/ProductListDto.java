package com.icia.dabyinsa.user.dto;

import lombok.Data;

@Data
public class ProductListDto {
	
	private String prod_id;
	private String prod_name;
	private int price;
	private int retail_price;
	private int special_member_price;
	private int taxrates;
	private String admin_prod_code;
	private String prod_summary_ex;
	private String prod_briefly_ex;
	private String prod_detail_ex;
	private String sale_dp;
	private String buy_rightoff;
	private String prod_meterial;
	private String supplier;
	private String making_company;
	private String making_date;
	private String making_contry;
	private String registration_date;
	private String fix_date;
	private int shipping_fee;
	private String prod_categry;	
	private String img_url;
	
	
	private String b_content;
	private String b_star;

	private int oi_amount;
	
	private int img_no_seq;
	private String pi_prod_id;
	private String oriname;
	private String sysname;
}

