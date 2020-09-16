package com.baizhi.entity;

import java.util.Date;

public class Item {
	private String id;
	private Integer book_id;
	private String order_id;
	private Integer count;
	private Date create_date;
	private String name;//书的名字
	private Double price;
	private Double dprice;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String id, Integer book_id, String order_id, Integer count,
			Date create_date, String name, Double price, Double dprice) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.order_id = order_id;
		this.count = count;
		this.create_date = create_date;
		this.name = name;
		this.price = price;
		this.dprice = dprice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Date getCreat_date() {
		return create_date;
	}
	public void setCreat_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDprice() {
		return dprice;
	}
	public void setDprice(Double dprice) {
		this.dprice = dprice;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", book_id=" + book_id + ", order_id="
				+ order_id + ", count=" + count + ", creat_date=" + create_date
				+ ", name=" + name + ", price=" + price + ", dprice=" + dprice
				+ "]";
	}
	
}
