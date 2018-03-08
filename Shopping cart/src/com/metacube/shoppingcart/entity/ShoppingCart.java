package com.metacube.shoppingcart.entity;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

	String userId;
	Map<Product, Integer> items = new HashMap<>();
	float totPrice;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
