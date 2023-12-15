package com.portpolio.controller.whatController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/whatProject/*")
public class WhatFrontController {
	@GetMapping(value= {"/","index"})
	public String index() {
		return "whatProject/index.html";
	}
	@GetMapping("/login-page")
	public String loginPage() {
		return "whatProject/login-page/login-page.html";
	}
}
