package com.baizhi.dao;


import java.util.List;

import com.baizhi.entity.Address;

public interface AddressDao {
	
	//查所有地址
	public List<Address> selectAllAddress(String id);
	
	//查一个地址
	public Address selectOneAddress(String addressid);
	
	//添加
	public void addAddress(Address address);
	
	//更新
	public void updateOneAddress(Address address);
}
