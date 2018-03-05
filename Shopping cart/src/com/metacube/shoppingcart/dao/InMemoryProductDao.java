package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;


import com.metacube.shoppingcart.entity.Product;

public class InMemoryProductDao implements BaseDao {
	
	Map<Integer , Product> allProducts = new HashMap<>();

	public Map<Integer, Product> getAll() {
		return this.allProducts;
	}

	public void addProduct(Product product) {
		this.allProducts.put(product.getId(), product);
		
	}
	
	public void removeProduct(int productId) {
		allProducts.remove(productId);
	}

	public void updateProduct(int productId, String productName, float price) {
		Product product = allProducts.get(productId);
		product.setName(productName);
		product.setPrice(price);
	}
	
}
