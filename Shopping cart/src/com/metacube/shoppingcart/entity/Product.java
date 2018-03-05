package com.metacube.shoppingcart.entity;

public class Product {
	private static int countId = 0;
	private int id;
	private String name;
	private float price;
	
	public Product(String name, float price){
		this.name = name;
		this.price = price;
		this.id = countId++;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
