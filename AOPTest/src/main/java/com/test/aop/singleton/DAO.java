package com.test.aop.singleton;


//객체 단 1개만 구현 > 싱글톤 패턴
public class DAO {

	
	private static DAO obj;
	
	//외부에서 볼 수 없어 외부에서 new로 객체를 직접 생성할 수 없음.
	private DAO() {
		
	}
	
	//프로세스
	//- 운영체제가 1개의 프로그램을 실행하는 단위
	
	
	//쓰레드(Thread) 안정성
	//- synchronized : 임계 영역을 생성하는 키워드
	
	public static synchronized DAO getInstance() {
		
		if (obj == null) {
			obj = new DAO();
		}
		
		return obj;
		
	}
	
	
}


