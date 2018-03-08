package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.dao.EntityType;
import com.metacube.shoppingcart.dao.OperationStatus;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.UserFacade;


/**
 * Controller to add user or product to memory (handles function calls and acts as a mediator between input and processing)
 * 
 * @author Amit Sharma 
 *
 * @param <T>
 */
public class Controller<T> {
	ProductFacade productFacade = ProductFacade.getInstance();
	UserFacade userFacade = UserFacade.getInstance();
	
	/**
	 * gives a call to add either a user or a product based on the input received
	 * 
	 * @param entity
	 * @param item
	 * @return
	 */
	public OperationStatus add (EntityType entity, T item){
		if(entity == EntityType.Product) {
			return productFacade.addProduct ( (Product) item);
		} else if (entity == EntityType.User) {
			return userFacade.addUser ( (User) item);
		}
		return null;
	}
	
	/**
	 * gives a call to return the list of either products or users based on the input
	 * 
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll (EntityType entity) {
		if (entity == EntityType.Product) {
			return (List<T>) productFacade.getAll ();
		}else if(entity == EntityType.User) {
			return (List<T>) userFacade.getAll ();
		}
		return null;	
	}
	
	/**
	 * gives a call to remove either product or user based on the input
	 * 
	 * @param entity
	 * @param id
	 * @return
	 */
	public OperationStatus remove (EntityType entity, T id) {
		if(entity == EntityType.Product){
			return productFacade.removeProduct ( (int) id);
		} else if (entity == EntityType.User) {
			return userFacade.removeUser ( (String) id);
		}
		return null;
	}

	/**
	 * gives a call to update either product or user based on the input
	 * 
	 * @param entity
	 * @param id
	 * @param name
	 * @param xyz
	 * @return
	 */
	public OperationStatus update (EntityType entity, T id, T name, T xyz) {
		if(entity == EntityType.Product) {
			return productFacade.updateProduct ( (int) id, (String) name, (float) xyz);
		}else if(entity == EntityType.User) {
			return userFacade.updateUser ( (String) id, (String) name, (String) xyz);
		}
		return null;
	}
}
