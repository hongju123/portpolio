package com.portpolio.controller.whatController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/what/*")
public class FrontController {
	@GetMapping("/")
	public String index() {
		return "whatProject/index.html";
	}
}
