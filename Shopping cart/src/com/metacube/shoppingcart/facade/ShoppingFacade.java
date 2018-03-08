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

public class ShoppingFacade {
private static ShoppingFacade obj;
	
	InMemoryCartDao objectDao =(InMemoryCartDao) Factory.getInstance(EntityType.Cart, DataBase.InMemory);
	
	public static ShoppingFacade getInstance() {
		if (obj == null) {
			obj = new ShoppingFacade();
		}
		
		return obj;
	}
	
	private ShoppingFacade() {}
	
	public Map<Product, Integer> getList(String Uid){
		Map<Product, Integer> productList = objectDao.getCart(Uid).getItems();
		return productList;
	}
	
	public float getTotPrice (String Uid){
		Map<Product, Integer> productList = getList(Uid);
		float tot = 0.0f;
		for( Entry<Product, Integer> m: productList.entrySet()){
			tot += (m.getKey().getPrice()*m.getValue());
		}
		return tot;
	}

	public Map<Product, Integer> addCart(String Uid, ShoppingCart cart) {
		
		if(objectDao.getCart(Uid) == null){
			cart.setUserId(Uid);
			objectDao.addCart(cart);
			return getList(Uid);
		} else {
			return getList(Uid);
		}
			
	}
	
	public OperationStatus removeCart(String Uid) {
		if( objectDao.getCart(Uid) != null ){
			objectDao.removeCart(Uid);
			return OperationStatus.User_removed;
		} else {
			return OperationStatus.No_such_User_found;
		}
	}
	
	public OperationStatus addToCart(String Uid, int productId, int quantity ){
		if(objectDao.getCart(Uid) != null){
			Product pro = ProductFacade.getInstance().getProduct(productId);
			objectDao.addProductToCart(Uid, pro, quantity);
			return OperationStatus.Update_successfull;
		} else {
			return OperationStatus.Error;
		}
	}
	public OperationStatus removeFromCart(String Uid, int productId ){
		if(objectDao.getCart(Uid) != null){
			Product pro = ProductFacade.getInstance().getProduct(productId);
			objectDao.removeProductFromCart(Uid, pro);
			return OperationStatus.Remove_successfull;
		} else {
			return OperationStatus.Error;
		}
	}

	public boolean checkUser(String uid) {
		return UserFacade.getInstance().checkUser(uid);
	}
}
