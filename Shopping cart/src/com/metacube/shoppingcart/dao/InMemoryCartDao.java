package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;

/**
 * In memory storage type DAO to perform operations on cart
 * 
 * @author Amit Sharma 
 *
 */
public class InMemoryCartDao implements BaseDao {
	Map<String , ShoppingCart> allCarts = new HashMap<>();

	/**
	 * gets the cart for the specified user
	 * 
	 * @param userID
	 * @return
	 */
	public ShoppingCart getCart(String userID) {
		return this.allCarts.get(userID);
	}
	
	/**
	 * returns all the carts present in memory
	 * 
	 * @return
	 */
	public Map<String, ShoppingCart> getAllCart() {
		return this.allCarts;
	}

	/**
	 * adds a cart for the current user
	 * 
	 * @param cart
	 */
	public void addCart(ShoppingCart cart) {
		this.allCarts.put(cart.getUserId(), cart);
		
	}
	
	/**
	 * removes the user's cart from memory
	 * 
	 * @param userID
	 */
	public void removeCart(String userID) {
		allCarts.remove(userID);
	}

	/**
	 * Adds the product to cart of the user
	 * 
	 * @param userID
	 * @param product
	 * @param quantity
	 */
	public void addProductToCart(String userID, Product product, int quantity) {
		ShoppingCart cart = getCart(userID);
		Map<Product, Integer> itemList = cart.getItems();
		itemList.put(product, quantity);
		cart.setItems(itemList);
	}

	/**
	 * removes the product from user's cart
	 * 
	 * @param userID
	 * @param product
	 */
	public void removeProductFromCart(String userID, Product product) {
		ShoppingCart cart = getCart(userID);
		Map<Product, Integer> itemList = cart.getItems();
		itemList.remove(product);
		cart.setItems(itemList);
	}
}
