package com.baizhi.entity;

import java.util.Date;

/*
 * create table dd_user  (
   id                   varchar2(20)                    not null,
   email                varchar2(20),
   password             varchar2(30),
   nickname             varchar2(30),
   code                 varchar2(20),
   status               varchar2(20),
   salt                 varchar2(20),
   create_date          date,
   constraint PK_DD_USER primary key (id)
)
 * */

public class User {
	private String id;
	private String email;
	private String password;
	private String nickname;
	private String code;
	private String status;
	private String salt;
	private Date create_date;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String email, String password, String nickname,
			String code, String status, String salt, Date create_date) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.code = code;
		this.status = status;
		this.salt = salt;
		this.create_date = create_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password
				+ ", nickname=" + nickname + ", code=" + code + ", status="
				+ status + ", salt=" + salt + ", create_date=" + create_date
				+ "]";
	}
	
}
