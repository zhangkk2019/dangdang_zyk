package com.baizhi.entity;

import java.util.Date;

public class Order {
	private String id;
	private String order_no;
	private Double total;
	private String status;
	private Date create_date;
	private String address_id;
	private String user_id;
	private String name;
	private String local;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, String order_no, Double total, String status,
			Date create_date, String address_id, String user_id, String name,
			String local) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.total = total;
		this.status = status;
		this.create_date = create_date;
		this.address_id = address_id;
		this.user_id = user_id;
		this.name = name;
		this.local = local;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", order_no=" + order_no + ", total="
				+ total + ", status=" + status + ", create_date=" + create_date
				+ ", address_id=" + address_id + ", user_id=" + user_id
				+ ", name=" + name + ", local=" + local + "]";
	}
	
}
