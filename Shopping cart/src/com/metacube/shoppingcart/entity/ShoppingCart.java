package com.metacube.shoppingcart.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Shopping Cart class to initialise the shopping cart for the user
 * 
 * @author Amit Sharma
 *
 */
public class ShoppingCart {

	String userID;
	Map<Product, Integer> items = new HashMap<>();
	float totPrice;
	
	/* Getters and Setters for all data members */
	public String getUserId() {
		return userID;
	}
	public void setUserId(String userID) {
		this.userID = userID;
	}
	public Map<Product, Integer> getItems() {
		return items;
	}
	public void setItems(Map<Product, Integer> items) {
		this.items = items;
	}
	public float getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(float totPrice) {
		this.totPrice = totPrice;
	}
	
	
	
	
}
