package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.service.OrderService;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.OrderServiceImpl;
import com.baizhi.service.impl.UserServiceImpl;

public class OrderAction {
	private List<Order> orderList;
	private String oid;//order id
	private String iid;//item  id
	private Order order;
	private Book book;
	private Item item;
	private Integer bookid;
	//查询所有order
	public String selectAllOrder() {
		OrderService service = new OrderServiceImpl();
		orderList = service.selectAllOrder();
		return "selectAllOrder";
	}
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	
}
