package com.test.begin.di1;

public class Main {
	
	public static void main(String[] args) {
		
		//목적] Hong에게 일을 시키자!
		//Main > Hong (X)
		//Main > Service > Hong (o)
		
		//Hong hong = new Hong();
		
		//Main > (위임) > Service > (위임) > Hong 
		//Main <--> (의존관계) <--> Service <--> (의존관계) <--> Hong 
		//Main > Service (의존객체) -> 메인에서 Service는 의존 객체
		
		//**** 필요할 때마다 직접(***) 의존 객체를 생성해서 사용하는 방식을 사용해왔다.
		
		
		Service service = new Service();
		service.work();
		
	}
	
}
