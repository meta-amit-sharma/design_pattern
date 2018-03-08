package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.dao.EntityType;
import com.metacube.shoppingcart.dao.OperationStatus;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.UserFacade;

public class Controller<T> {
	ProductFacade productFacade = ProductFacade.getInstance();
	UserFacade userFacade = UserFacade.getInstance();
	
	public OperationStatus add(EntityType e,T item){
		if(e == EntityType.Product){
			return productFacade.addProduct((Product)item);
		} else if (e == EntityType.User) {
			return userFacade.addUser((User)item);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(EntityType e){
		if(e == EntityType.Product){
			return (List<T>) productFacade.getAll();
		}else if(e == EntityType.User){
			return (List<T>) userFacade.getAll();
		}
		return null;	
	}
	
	public OperationStatus remove(EntityType e, T id){
		if(e == EntityType.Product){
			return productFacade.removeProduct((int)id);
		}else if(e == EntityType.User){
			return userFacade.removeUser((String)id);
		}
		return null;
	}

	public OperationStatus update(EntityType e, T id, T name, T xyz) {
		if(e == EntityType.Product){
			return productFacade.updateProduct((int)id,(String)name,(float)xyz);
		}else if(e == EntityType.User){
			return userFacade.updateUser((String)id,(String)name,(String)xyz);
		}
		return null;
	}
	
	
}
