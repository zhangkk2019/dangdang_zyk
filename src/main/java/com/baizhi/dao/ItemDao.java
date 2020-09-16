package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Item;

public interface ItemDao {
	//添加订单项
	public void addItem(Item item);
	//
	public List<Item> selectOneItem(@Param("oid")String oid);
}
