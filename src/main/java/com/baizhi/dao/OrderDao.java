package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Order;

public interface OrderDao {
	//添加一个订单
	public void addOrder(Order order);
	
	//查询所有订单
	public List<Order> selectAllOrder();
	
	//通过id查一个订单
	public Order selectOneOrder(String id);
}
