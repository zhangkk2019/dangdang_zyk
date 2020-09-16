package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Order;

public interface OrderService {
	//查询所有订单
	public List<Order> selectAllOrder();
	
	//通过id查一个订单
	public Order selectOneOrder(String id);
}
