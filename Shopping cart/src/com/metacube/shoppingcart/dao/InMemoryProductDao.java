package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;


import com.metacube.shoppingcart.entity.Product;

/**
 * In memory storage type DAO to perform operations on products
 * 
 * @author Amit Sharma 
 *
 */
public class InMemoryProductDao implements BaseDao {
	
	Map<Integer, Product> allProducts = new HashMap<>();

	/**
	 * returns the list of all the products
	 * 
	 * @return
	 */
	public Map<Integer, Product> getAll() {
		return this.allProducts;
	}

	/**
	 * adds the product to the list
	 * @param product
	 */
	public void addProduct (Product product) {
		this.allProducts.put (product.getId (), product);
		
	}
	
	/**
	 * removes the product from the list
	 * @param productID
	 */
	public void removeProduct(int productID) {
		allProducts.remove(productID);
	}

	/**
	 * update product details
	 * 
	 * @param productID
	 * @param productName
	 * @param price
	 */
	public void updateProduct(int productID, String productName, float price) {
		Product product = allProducts.get (productID);
		product.setName (productName);
		product.setPrice (price);
	}
	
}
