package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.metacube.shoppingcart.dao.*;
import com.metacube.shoppingcart.entity.Product;

/**
 * All the business logic for the Product resides here
 * (Singleton class)
 * 
 * @author Amit Sharma 
 *
 */

public class ProductFacade {
	private static ProductFacade obj;
	
	InMemoryProductDao objectDao =(InMemoryProductDao) Factory.getInstance(EntityType.Product, DataBase.InMemory);
	//Singleton object creation
	public static ProductFacade getInstance() {
		if (obj == null) {
			obj = new ProductFacade();
		}
		
		return obj;
	}
	
	private ProductFacade() {}
	//ends
	/**
	 * Function to return all the products in a list
	 * @return
	 */
	public List<Product> getAll(){
		List<Product> list = new ArrayList<>();
		for(Entry<Integer, Product> e: objectDao.getAll().entrySet()){
			list.add((Product)e.getValue());
		}
		return list;
	}
	/**
	 * Returns the product of required Id 
	 * @param productId
	 * @return
	 */
	public Product getProduct(int productId){
		return objectDao.getAll().get(productId);
	}
	
	/**
     * Add a new product in the memory
     * @param product
     * @return
     */
	public OperationStatus addProduct(Product product) {
		objectDao.addProduct(product);
			return OperationStatus.Product_added;
	}
	
	/**
	 * To remove the product of given Id
	 * @param productId
	 * @return
	 */
	public OperationStatus removeProduct(int productId) {
		if( objectDao.getAll().containsKey(productId) ){
			objectDao.removeProduct(productId);
			return OperationStatus.Product_removed;
		} else {
			return OperationStatus.No_such_product_found;
		}
	}
	
	/**
	 * To update the product name and price of 
	 * given Product id
	 * @param productId
	 * @param productName
	 * @param price
	 * @return
	 */
	public OperationStatus updateProduct(int productId, String productName, float price ){
		if(objectDao.getAll().containsKey(productId)){
			objectDao.updateProduct(productId, productName, price);
			return OperationStatus.Update_successfull;
		} else {
			return OperationStatus.No_such_product_found;
		}
	}
}
