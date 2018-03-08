package com.metacube.shoppingcart.entity;

/**
 * Product class to store information of all products
 * 
 * @author Amit Sharma 
 *
 */
public class Product {
	private static int countId = 0;
	private int id;
	private String name;
	private float price;
	
	/**
	 * Constructor to set product details
	 * 
	 * @param name
	 * @param price
	 */
	public Product(String name, float price){
		this.name = name;
		this.price = price;
		this.id = countId++;
	}
	
	/* Getters and Setters for all data members */
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
