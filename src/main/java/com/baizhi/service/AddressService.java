package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressService {
	//查询所有地址
	public List<Address> selectAllAddress(String id);
	
	//根据id查询一个地址
	public Address selectOneAddress(String addressid);
	
	//
	public void addOrder(Address address);
}
