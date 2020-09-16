package com.baizhi.service;

public interface CartService {
	//添加购物车
	public void addCart(int id);
	
	//变更数量
	public void updateCount(int count,int id);
	
	//删除购物车项
	public void deleteCart(int id);
}
