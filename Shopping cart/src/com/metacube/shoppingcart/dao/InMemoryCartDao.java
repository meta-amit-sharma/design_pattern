package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;

public class InMemoryCartDao implements BaseDao {
	Map<String , ShoppingCart> allCarts = new HashMap<>();

	public ShoppingCart getCart(String userId) {
		return this.allCarts.get(userId);
	}
	
	public Map<String, ShoppingCart> getAllCart() {
		return this.allCarts;
	}

	public void addCart(ShoppingCart cart) {
		this.allCarts.put(cart.getUserId(), cart);
		
	}
	
	public void removeCart(String userId) {
		allCarts.remove(userId);
	}

	public void addProductToCart(String userId, Product product, int quantity) {
		ShoppingCart cart = getCart(userId);
		Map<Product, Integer> itemList = cart.getItems();
		itemList.put(product, quantity);
		cart.setItems(itemList);
	}

	public void removeProductFromCart(String uid, Product pro) {
		ShoppingCart cart = getCart(uid);
		Map<Product, Integer> itemList = cart.getItems();
		itemList.remove(pro);
		cart.setItems(itemList);
	}
}
