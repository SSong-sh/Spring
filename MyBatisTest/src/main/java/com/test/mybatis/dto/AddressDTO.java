package com.test.mybatis.dto;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDTO {

	private String seq;
	private String name;
	private String age;
	private String address;
	private String gender;
	
	private InfoDTO info;
	private List<MemoDTO> memo;
}
