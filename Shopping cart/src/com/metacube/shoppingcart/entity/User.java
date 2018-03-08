package com.metacube.shoppingcart.entity;

public class User {
	private String userid;
	private String password;
	private String name;
	
	public User(String uid, String name, String pass){
		this.userid = uid;
		this.name = name;
		this.password = pass;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
