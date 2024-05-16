package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//스프링이 빈으로 관리하는 대상 있는 곳 > component-scan base-package="com.test.web"

//빈이 되기 위한 자격 
//- @Component 
//- @Controller > 컨트롤러 역할
//- @Service > 서비스 역할
//- @Repository > DAO 역할


//Controller이 Component를 상속
@Controller
public class Ex07Controller {
	
	//org.springframework.web.servlet.PageNotFound
	@GetMapping("/ex07.do")
	public String ex07() {
		
		return "ex07";
	}
}
