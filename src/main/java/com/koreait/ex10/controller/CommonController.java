package com.koreait.ex10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // @Controller 
public class CommonController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
}
