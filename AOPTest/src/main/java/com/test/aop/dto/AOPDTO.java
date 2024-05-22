package com.test.aop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//독립성을 유지해야 가치가 있어야 하기 때문에 dto은 빈으로 만들지 않음 (싱글톤 성격x)
public class AOPDTO {

	private String name;
	private String age;
	private String color;
	
}
