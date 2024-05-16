package com.test.web.connect;

public class Main {
	
	
	public static void main(String[] args) {
		
		//Main >  Service > Hong
		
		//*** 계층과 계층간에 연결 > 클래스 사용(x), 인터페이스 사용(o) > 권장 
		Service service = new Service();
		service.work();
	}

}
