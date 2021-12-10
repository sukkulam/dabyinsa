package com.icia.dabyinsa.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

	@GetMapping("/main")
	public String main() {
		return "admin/main";
	}

	@GetMapping("/adorderlist")
	public String adorderlist() {
		return "admin/adorderlist";
	}
}
