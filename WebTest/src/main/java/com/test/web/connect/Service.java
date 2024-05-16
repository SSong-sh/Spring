package com.test.web.connect;

public class Service {
	
	public void work() {
		
		//클래스를 사용한 관계 > 강한 결합
		//인터페이스를 사용한 관계 > 느슨한 결합
		
		//Hong worker = new Hong();
		//Lee worker = new Lee();
		
		//Worker worker = new Lee();
		Worker worker = new Hong();
		
		String thing = worker.get("키보드");
		System.out.println(thing);
		
	}
	
		
}
