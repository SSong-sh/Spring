package com.test.web.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ex06Controller {

	@GetMapping("/add.do")
	public String add() {
		
		return "add";
	}
	
	/*
	@PostMapping("/addok.do")
	public String addok(HttpServletRequest req, HttpServletResponse resp) {
		
		//req.setCharacterEncoding("UTF-8");
		
		String num = req.getParameter("num");
		
		req.setAttribute("num", num);
		
		return "addok";
	}
	*/
	
	
	//스프링에서는 요청 메서드에게 넘어오는 대부분의 데이터를 매개 변수 형태로 받는다.
	//스프링의 매개변수는 암시적으로 형변환을 해준다.
//	@PostMapping("/addok.do")
//	public String addok(@RequestParam("num") String num) {
//		
//		System.out.println(num);
//		
//		return "addok";
//				
//	}
	
//	@PostMapping("/addok.do")
//	//request가 생략되면 매개변수 명이 request 명이 되기 때문에 이름 함부로 바꾸지 않기! (조심)!
//	public String addok(String num, Model model) {
//		
//		System.out.println(num);
//		
//		//ModelAndView
//		
//		model.addAttribute("num",num);
//		
//		return "addok";
//				
//	}
	
//	@PostMapping("/addok.do")
//	public String addok(Model model,
//								@RequestParam("name") String name,
//								@RequestParam("age") String age,
//								@RequestParam("address") String address) {
//		
//		model.addAttribute("name", name);
//		model.addAttribute("age", age);
//		model.addAttribute("address", address);
//		
//		
//		return "addok";
//	}
	
	/*
	@PostMapping("/addok.do")
	public String addok(Model model,
						String name,
						int age,
						String address) {
		
		//가장 많이 하는 행동? > DTO 담기
		AddressDTO dto = new AddressDTO();
		dto.setName(name);
		dto.setAge(age);
		dto.setAddress(address);
		
		
//		model.addAttribute("name", name);
//		model.addAttribute("age", age);
//		model.addAttribute("address", address);
		
		model.addAttribute("dto",dto);
		
		return "addok";
		
	}
	*/
	
	/*
	@PostMapping("/addok.do")
	//int는 값이 없을때 null처리가 안되면 에러 발생 ->  default 값 지정
	public String addok(Model model, AddressDTO dto, @RequestParam(defaultValue= "100") int id) {
		
		
		//1. req.getParameter()
		//2. DTO 생성
		
		System.out.println(id);
		model.addAttribute("dto",dto);
		
		return "addok";
		
	}
	*/
	
	/*
	@PostMapping("/addok.do")
	public String addok(Model model 
						//, String cb
						//,@RequestParam("cb") String [] cb
						//,@RequestParam("cb") List<String> cb
						//, ArrayList<String> cb
						//, String[] cb
						//, List<String> cb { 
			
		//1,2,3,4,5
		//[1, 2, 3, 4, 5] - List
		//[]으로 출력(@RequestParam 필수)
		System.out.println(cb);
	
		//[1, 2, 3, 4, 5]
		//System.out.println(Arrays.toString(cb));
		
		return "addok";
		
	}
	
	*/
	
	@PostMapping("/addok.do")
	public String addok(Model model, @ModelAttribute("num") String num) { 
			
		//@ModelAttribute
		//- 모델 객체에 데이터를 추가하지 않아도 자동으로 추가된다.
		
		return "addok";
		
	}
	
}
