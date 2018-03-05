package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.metacube.shoppingcart.dao.InMemoryProductDao;
import com.metacube.shoppingcart.dao.ProductFactory;
import com.metacube.shoppingcart.dao.db;
import com.metacube.shoppingcart.dao.status;
import com.metacube.shoppingcart.entity.Product;



public class ProductFacade {
	private static ProductFacade obj;
	
	InMemoryProductDao inmemorydao =(InMemoryProductDao) ProductFactory.getInstance(db.InMemory);
	
	public static ProductFacade getInstance() {
		if (obj == null) {
			obj = new ProductFacade();
		}
		
		return obj;
	}
	
	private ProductFacade() {}
	
	public List<Product> getAll(){
		List<Product> list = new ArrayList<>();
		for(Entry<Integer, Product> e: inmemorydao.getAll().entrySet()){
			list.add((Product)e.getValue());
		}
		return list;
	}

	public status addProduct(Product product) {
		inmemorydao.addProduct(product);
			return status.Product_added;
	}
	
	public status removeProduct(int productId) {
		if( inmemorydao.getAll().containsKey(productId) ){
			inmemorydao.removeProduct(productId);;
			return status.Product_removed;
		} else {
			return status.No_such_product_found;
		}
	}
	
	public status updateProduct(int productId, String productName, float price ){
		if(inmemorydao.getAll().containsKey(productId)){
			inmemorydao.updateProduct(productId, productName, price);
			return status.Update_successfull;
		} else {
			return status.No_such_product_found;
		}
	}
}
