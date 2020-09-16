package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Item;
import com.baizhi.service.ItemService;
import com.baizhi.service.impl.ItemServiceImpl;

public class ItemAction {
	private List<Item> itemList;
	private String oid;
	
	public String selectOneItem(){
		System.out.println(oid);
		ItemService service = new ItemServiceImpl();
		
			itemList = service.selectOneItem(oid);
		
		System.out.println("action****"+itemList);
		return "selectOneItem";
	}
	
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	
}
