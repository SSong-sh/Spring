package com.test.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@ApiModel(value = "AddressDTO(주소정보)",description = "주소 데이터를 전달합니다.")
public class AddressDTO {

	@ApiModelProperty(value = "데이터의 식별자", required = true, example = "1")
	private String seq; 
	
	@ApiModelProperty(value = "회원의 이름", required = true, example = "아무개")
	private String name;
	
	@ApiModelProperty(value = "회원의 나이", required = true, example = "25")
	private String age;
	
	@ApiModelProperty(value = "회원의 주소", required = true, example = "서울시 강남구")
	private String address;
	
	@ApiModelProperty(value = "회원의 성별", required = true, example = "f")
	private String gender;
	
	
}
