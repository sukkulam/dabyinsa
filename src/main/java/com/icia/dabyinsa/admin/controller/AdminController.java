package com.icia.dabyinsa.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/main")
	public String admin() {
		return "admin/admin";
	}
}
