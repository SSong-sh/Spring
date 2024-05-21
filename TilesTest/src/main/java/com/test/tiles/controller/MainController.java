package com.test.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/index.do")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/test.do")
	public String testndex() {
		
		
		//Tiles 적용 > return 값 > JSP(x)
		//						 > definition의 name 값
		return "test";
	}
}
