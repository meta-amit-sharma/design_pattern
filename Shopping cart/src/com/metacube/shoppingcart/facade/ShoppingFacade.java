package com.metacube.shoppingcart.facade;

import java.util.Map;
import java.util.Map.Entry;

import com.metacube.shoppingcart.dao.DataBase;
import com.metacube.shoppingcart.dao.EntityType;
import com.metacube.shoppingcart.dao.Factory;
import com.metacube.shoppingcart.dao.InMemoryCartDao;
import com.metacube.shoppingcart.dao.OperationStatus;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;

/**
 * All the business logic for the shopping cart resides here
 * (Singleton class)
 * 
 * @author Amit Sharma 
 *
 */
public class ShoppingFacade {
	//Singleton object creation
	private static ShoppingFacade obj;
	
	InMemoryCartDao objectDao =(InMemoryCartDao) Factory.getInstance(EntityType.Cart, DataBase.InMemory);
	
	public static ShoppingFacade getInstance() {
		if (obj == null) {
			obj = new ShoppingFacade();
		}
		
		return obj;
	}
	
	private ShoppingFacade() {}
	//ends
	
	/**
	 * gets the list of products in user's cart
	 * 
	 * @param userID
	 * @return
	 */
	public Map<Product, Integer> getList(String userID){
		Map<Product, Integer> productList = objectDao.getCart(userID).getItems();
		return productList;
	}
	
	/**
	 * returns total price of the cart
	 * 
	 * @param userID
	 * @return
	 */
	public float getTotPrice (String userID){
		Map<Product, Integer> productList = getList(userID);
		float tot = 0.0f;
		for( Entry<Product, Integer> m: productList.entrySet()){
			tot += (m.getKey().getPrice()*m.getValue());
		}
		return tot;
	}

	/**
	 * checks if a cart exist, if it doesn't adds one
	 * 
	 * @param userID
	 * @param cart
	 * @return
	 */
	public Map<Product, Integer> addCart(String userID, ShoppingCart cart) {
		
		if(objectDao.getCart(userID) == null){
			cart.setUserId(userID);
			objectDao.addCart(cart);
			return getList(userID);
		} else {
			return getList(userID);
		}
			
	}
	
	/**
	 * checks if a cart exist, if it does, it removes it.
	 * 
	 * @param usreID
	 * @return
	 */
	public OperationStatus removeCart(String usreID) {
		if( objectDao.getCart(usreID) != null ){
			objectDao.removeCart(usreID);
			return OperationStatus.User_removed;
		} else {
			return OperationStatus.No_such_User_found;
		}
	}
	
	/**
	 * checks if a cart exist, it also checks if the entered product ID exists, if it does, it adds one
	 * 
	 * @param userID
	 * @param productID
	 * @param quantity
	 * @return
	 */
	public OperationStatus addToCart(String userID, int productID, int quantity ){
		if(objectDao.getCart(userID) != null){
			Product pro = ProductFacade.getInstance().getProduct(productID);
			if(pro == null){
				return OperationStatus.No_such_product_found;
			}
			objectDao.addProductToCart(userID, pro, quantity);
			return OperationStatus.Update_successfull;
		} else {
			return OperationStatus.Error;
		}
	}
	
	/**
	 * checks if a cart exist, it also checks if the entered product ID exists in the cart, if it does, it removes the product
	 * 
	 * @param userID
	 * @param productID
	 * @return
	 */
	public OperationStatus removeFromCart(String userID, int productID ){
		if(objectDao.getCart(userID) != null){
			Product pro = ProductFacade.getInstance().getProduct(productID);
			if(pro == null){
				return OperationStatus.No_such_product_found;
			}if(!objectDao.getCart(userID).getItems().containsKey(pro)){
				return OperationStatus.No_such_product_in_your_cart;
			}
			objectDao.removeProductFromCart(userID, pro);
			return OperationStatus.Remove_successfull;
		} else {
			return OperationStatus.Error;
		}
	}

	/**
	 * checks if the user is present in the system
	 * 
	 * @param userID
	 * @return
	 */
	public boolean checkUser(String userID) {
		return UserFacade.getInstance().checkUser(userID);
	}
}
