package com.metacube.shoppingcart.entity;

/**
 * User Class to initialize All the users
 * 
 * @author Amit Sharma
 *
 */
public class User {
	private String userid;
	private String password;
	private String name;
	
	/**
	 * Constructor to set all the details of user
	 * 
	 * @param uid
	 * @param name
	 * @param pass
	 */
	public User(String uid, String name, String pass){
		this.userid = uid;
		this.name = name;
		this.password = pass;
	}
	
	/* Getters and Setters for all data variables */
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
