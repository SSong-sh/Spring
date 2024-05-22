package com.test.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.aop.dao.AOPDAO;
import com.test.aop.dto.AOPDTO;
import com.test.aop.dto.BoardDTO;
import com.test.aop.dto.CommentDTO;
import com.test.aop.singleton.TestDAO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
// 서버와 같은 같은 일을 하는 부분은 메모리 자원을 생각해 스프링 빈으로 생성하는 것이 바람직
public class AOPController {
	
	private final AOPDAO dao; //수업용
	
	
	private final AOPDAO dao2;
	private final TestDAO dao3;
	
	
	@GetMapping("/test.do")
	public String test() {
		
		//스프링이 관리하는 모든 빈은 싱글톤

		//원하는 값으로만 객체를 만들기 어려움
		//MemoDTO m1 = new MemoDTO(null, null, null, null, null)
	
		//생성자 순서가 자유로움
		//생성자 객체를 자유롭게 만들 수 있음 > 생성자 오버로딩과 같음
		BoardDTO b1 = new BoardDTO.BoardDTOBuilder()
					.setSeq("1")
					.setSubject("제목입니다.")
					.setContent("내용입니다.")
					.setName("홍길동")
					.setRegdate("2024")
					.bulid();
		
		System.out.println(b1);
		
		CommentDTO c1 = CommentDTO.builder()
									.name("홍길동")
									.subject("댓글입니다.")
									.content("내용입니다.")
									.build();
		
		System.out.println(c1);
	
//		System.out.println(dao == dao2);  //true
//		System.out.println(dao.equals(dao2)); //true
//		System.out.println(dao3.service()); //data
		
//		AOPDTO dto1 = new AOPDTO();
//		
//		AOPDTO dto2 = new AOPDTO();
//		
//		//주소값 비교라 둘다 false (참조형)
//		System.out.println(dto1==dto2);
//		System.out.println(dto1.equals(dto2));
//		
//		
//		DAO dao1 = new DAO();
//		
//		DAO dao2 = DAO.getInstance();
//		DAO dao3 = DAO.getInstance();
//		
//		System.out.println(dao2==dao3); //true
//		System.out.println(dao2.equals(dao3)); //true
//		
		return "list";
	
	}
	
	
	@GetMapping("/list.do")
	public String list() {
		
		//주요 업무 > 메모장
		//보조 업무 > 로그
		
		System.out.println("Controller.list");
		dao.list();
		
		return "list";
	}
	
	@GetMapping("/add.do")
	public String add() {
		
		AOPDTO dto = new AOPDTO();
		
		dto.setName("병아리");
		dto.setAge("1");
		dto.setColor("노랑");
		
		System.out.println("Controller.add");
		dao.add(dto);
		
		return "add";
	}
	
	@GetMapping("/view.do")
	public String view() {
		
		System.out.println("Controller.view");
		dao.view();
		
		return "view";
	}
	
	
}