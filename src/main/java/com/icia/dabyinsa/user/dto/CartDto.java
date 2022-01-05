package com.icia.dabyinsa.user.dto;

import lombok.Data;

@Data
public class CartDto {
	private int c_id;//카트번호
	private String m_id;//멤버아이디
	private String prod_id;//제품아이디
	private int prod_ea;//상품수량
	private	String prod_name;//상품이름
	private int price;//상품가격
	private int money;//총가격
	private String img_name;//상품이미지이름
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public int getProd_ea() {
		return prod_ea;
	}
	public void setProd_ea(int prod_ea) {
		this.prod_ea = prod_ea;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	@Override
	public String toString() {
		return "CartDto [c_id=" + c_id + ", m_id=" + m_id + ", prod_id=" + prod_id + ", prod_ea=" + prod_ea
				+ ", prod_name=" + prod_name + ", price=" + price + ", money=" + money + ", img_name=" + img_name + "]";
	}
}
