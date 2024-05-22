package com.test.rest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.rest.dto.AddressDTO;

public interface AddressDAO {

	AddressDTO m1();

	int add(AddressDTO dto);

	List<AddressDTO> list();

	int edit(AddressDTO dto);

	int del(String seq);

	AddressDTO get(String seq);

}
