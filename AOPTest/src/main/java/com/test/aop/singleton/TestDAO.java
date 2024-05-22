package com.test.aop.singleton;

import org.springframework.stereotype.Repository;

// 빈 선언
//1. xml : <bean>
//2. Annotaion : @Component
//3. Java : 자바 설정 파일

//@Repository
public class TestDAO {

	public String service() {
		return "data";
	}
}
