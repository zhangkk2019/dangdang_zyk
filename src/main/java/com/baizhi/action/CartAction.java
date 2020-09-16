package com.baizhi.action;

import com.baizhi.service.CartService;
import com.baizhi.service.impl.CartServiceImpl;

public class CartAction {
	private int id;//book id
	private int count;
	
	//添加购物车
	public String addCart(){
		CartService service = new CartServiceImpl();
		service.addCart(id);
		return "addCart";
	}
	
	//变更商品数量
	public String updateCount(){
		CartService service = new CartServiceImpl();
		try{
			service.updateCount(count, id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "updateCount";
	}
	
	//删除商品
	public String deleteCart(){
		CartService service = new CartServiceImpl();
		try{
			service.deleteCart(id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "deleteCart";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
