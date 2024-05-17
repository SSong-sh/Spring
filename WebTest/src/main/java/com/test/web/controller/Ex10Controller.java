package com.test.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.web.service.BoardService;
import com.test.web.service.DataService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


/*
 
	스프링 의존 주입
	1. 필드 주입, Field Injection
	2. Setter 주입
	3. 생성자 주입 > *** 가장 권장 > 생성자는 한번만 호출 되기 때문에 값이 변할 일이 없음

 */




@Controller
//@NoArgsConstructor 매개변수가 없는 생성자
//@AllArgsConstructor 모든 매개변수로 만든 생성사
@RequiredArgsConstructor //필요한 것만 매개변수로 만든 생성자
public class Ex10Controller {
	
	 //private final BoardService service; //의존주입할 매개변수로 final로 선언
	 //@Qualifier("memo")
	 private final DataService service; //의존주입할 매개변수로 final로 선언	
	
	//Autowired는 final 변수를 만들 수 없음
	//@Autowired
	//private BoardService service;
	
//	@Autowired
//	public void setService(BoardService service) {
//		this.service = service;
//		
//	}
	
//	@Autowired
//	public Ex10Controller(BoardService service) {
//		this.service = service;
//	}
	

	@GetMapping(value="/addBoard.do")
	public String add(String message) {
		
		//BoardService service = new BoardService();
		
		service.add(message);
		
		return "ex10";
	}
	
}


