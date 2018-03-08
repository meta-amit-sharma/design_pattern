package com.metacube.shoppingcart.controller;
import java.util.Map;

import com.metacube.shoppingcart.dao.OperationStatus;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.facade.ShoppingFacade;

/**
 * Controller For Shopping Cart (handles function calls and acts as a mediator between input and processing)
 * @author Amit Sharma 
 *
 */
public class CartController {
	ShoppingFacade shopFacade = ShoppingFacade.getInstance();
	
	/**
	 * gives a call to create a new cart for user
	 * 
	 * @param userID
	 * @param cart
	 * @return
	 */
	public Map<Product, Integer> newCart(String userID, ShoppingCart cart){
		return shopFacade.addCart(userID, cart);
	}
	
	/**
	 * gives a call to check for existence of a user account
	 * @param userID
	 * @return
	 */
	public boolean checkUser(String userID){
		return shopFacade.checkUser(userID);
	}
	
	/**
	 * gives a call to get cart list till moment
	 * @param userID
	 * @return
	 */
	public Map<Product, Integer> getList (String userID){
		return shopFacade.getList (userID);
	}
	
	/**
	 * gives a call to add to cart, the product selected by user
	 * @param userID
	 * @param productID
	 * @param quantity
	 * @return
	 */
	public OperationStatus addToCart (String userID, int productID, int quantity){
		return shopFacade.addToCart (userID, productID, quantity);
	}
	
	/**
	 * gives a call to remove from cart, the product selected by user
	 * @param userID
	 * @param productID
	 * @return
	 */
	public OperationStatus removeFromCart(String userID, int productID){
		return shopFacade.removeFromCart(userID,productID);
	}
	
	/**
	 * gives a call to remove the user's cart
	 * @param userID
	 * @return
	 */
	public OperationStatus removeCart(String userID) {
		return shopFacade.removeCart(userID);
	}
	
	/**
	 * gives a call to get total price of the user's cart
	 * @param userID
	 * @return
	 */
	public float getTotPrice(String userID){
		return shopFacade.getTotPrice(userID);
	}
}
