package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.metacube.shoppingcart.dao.*;
import com.metacube.shoppingcart.entity.Product;



public class ProductFacade {
	private static ProductFacade obj;
	
	InMemoryProductDao objectDao =(InMemoryProductDao) Factory.getInstance(EntityType.Product, DataBase.InMemory);
	
	public static ProductFacade getInstance() {
		if (obj == null) {
			obj = new ProductFacade();
		}
		
		return obj;
	}
	
	private ProductFacade() {}
	
	public List<Product> getAll(){
		List<Product> list = new ArrayList<>();
		for(Entry<Integer, Product> e: objectDao.getAll().entrySet()){
			list.add((Product)e.getValue());
		}
		return list;
	}
	
	public Product getProduct(int id){
		return objectDao.getAll().get(id);
	}
	
	public OperationStatus addProduct(Product product) {
		objectDao.addProduct(product);
			return OperationStatus.Product_added;
	}
	
	public OperationStatus removeProduct(int productId) {
		if( objectDao.getAll().containsKey(productId) ){
			objectDao.removeProduct(productId);
			return OperationStatus.Product_removed;
		} else {
			return OperationStatus.No_such_product_found;
		}
	}
	
	public OperationStatus updateProduct(int productId, String productName, float price ){
		if(objectDao.getAll().containsKey(productId)){
			objectDao.updateProduct(productId, productName, price);
			return OperationStatus.Update_successfull;
		} else {
			return OperationStatus.No_such_product_found;
		}
	}
}
