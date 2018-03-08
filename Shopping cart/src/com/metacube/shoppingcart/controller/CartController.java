package com.metacube.shoppingcart.controller;

import java.util.Map;

import com.metacube.shoppingcart.dao.OperationStatus;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.facade.ShoppingFacade;

public class CartController {
	ShoppingFacade shopFacade = ShoppingFacade.getInstance();
	
	public Map<Product, Integer> newCart(String uid, ShoppingCart cart){
		return shopFacade.addCart(uid, cart);
	}
	
	public boolean checkUser(String uid){
		return shopFacade.checkUser(uid);
	}
	
	public Map<Product, Integer> getList (String Uid){
		return shopFacade.getList(Uid);
	}
	
	public OperationStatus addToCart(String Uid, int productId, int quantity){
		return shopFacade.addToCart(Uid,productId,quantity );
	}
	
	public OperationStatus removeFromCart(String Uid, int productId){
		return shopFacade.removeFromCart(Uid,productId);
	}
	public OperationStatus removeCart(String Uid) {
		return shopFacade.removeCart(Uid);
	}
	public float getTotPrice(String Uid){
		return shopFacade.getTotPrice(Uid);
	}
}
