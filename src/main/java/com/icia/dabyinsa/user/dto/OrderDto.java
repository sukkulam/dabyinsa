package com.icia.dabyinsa.user.dto;

import lombok.Data;

@Data
public class OrderDto {

   String o_code;
   String m_id;
   String sop_sel;
   String cp_id;
   String prod_id;
   String o_date;
   String o_msg;
   String o_recipient;
   int o_post;
   String o_address;
   String o_add;
   int o_num;
   String o_email;
   int p_pay;
   int p_bank;
   int p_save;
   int p_status;
   int d_status;
   int o_coup;
   String ship_num;
   String ship_com;
   int proc_status;
   
   //order_item
   int oi_num;
   int oi_amount;
   int oi_totalprice;
   
   

   //prod_info
   public String prod_name;
   public int price;
   public int retail_price;
   public int special_member_price;
   public int taxrates;
   public String admin_prod_code;
   public String prod_summary_ex;
   public String prod_briefly_ex;
   public String prod_detail_ex;
   public String sale_dp;
   public String buy_rightoff;
   public String prod_meterial;
   public String supplier;
   public String making_company;
   public String making_date;
   public String making_contry;
   public String registration_date;
   public String fix_date;
   public int shipping_fee;
   public String prod_categry;   
   public String img_url;
   
   public String b_content;
   
   public int opointUse;
   
   public int getOpointUse() {
      return opointUse;
   }

   public void setOpointUse(int opointUse) {
      this.opointUse = opointUse;
   }

   // Member
   public int m_point;


   public int getM_point() {
      return m_point;
   }

   public void setM_point(int m_point) {
      this.m_point = m_point;
   }

   


}


