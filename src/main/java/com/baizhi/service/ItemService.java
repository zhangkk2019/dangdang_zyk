package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Item;

public interface ItemService {
	
	public List<Item> selectOneItem(String oid);
}
