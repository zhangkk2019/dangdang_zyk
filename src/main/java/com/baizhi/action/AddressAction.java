package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.AddressService;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.AddressServiceImpl;
import com.baizhi.service.impl.UserServiceImpl;

public class AddressAction {
	private String id;
	private String addressid;
	private List<Address> addressList;
	private Address address;
	private User adduser;
	
	public String selectAddress(){
		//获取addressService
		AddressService addressService = new AddressServiceImpl();
		UserService userService = new UserServiceImpl();
		System.out.println("查一个地址使所用的地址id:  "+addressid);
		//必然要查询的数据
		addressList = addressService.selectAllAddress(id);
		//System.out.println("点击前"+adduser.getId());
		//选择性查询的数据
		if(addressid!=null||"".equals(addressid)){
			System.out.println("第二次查一个地址使所用的地址id:  "+addressid);
			System.out.println("第二次查一个地址使所用的用户id:  "+id);
			address = addressService.selectOneAddress(addressid);
		}
		return "selectAddress";
		
	}
	
	
	//
	public String addOrder(){
		AddressService addressService = new AddressServiceImpl();
		addressService.addOrder(address);
		return "addOrder";
	}
	
	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}


	public User getAdduser() {
		return adduser;
	}


	public void setAdduser(User adduser) {
		this.adduser = adduser;
	}
	
	
	
	
}
