package com.baizhi.entity;

public class Address{
	private String id;
	private String name;//收件人
	private String local; //收件地址
	private String phone;
	private String zip_code; //邮编
	private String user_id;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String id, String name, String local, String phone,
			String zip_code, String user_id) {
		super();
		this.id = id;
		this.name = name;
		this.local = local;
		this.phone = phone;
		this.zip_code = zip_code;
		this.user_id = user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", local=" + local
				+ ", phone=" + phone + ", zip_code=" + zip_code + ", user_id="
				+ user_id + "]";
	}
	
	
}
