package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.dao.status;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.facade.ProductFacade;

public class Controller {
	ProductFacade productFacade = ProductFacade.getInstance();
	
	
	public status addProduct(Product product){
		return productFacade.addProduct(product);
	}
	
	public List<Product> getAll(){
		return productFacade.getAll();
	}
	
	public status removeProduct(int productId){
		return productFacade.removeProduct(productId);
	}

	public status updateProduct(int id, String name, float price) {
		return productFacade.updateProduct(id,name,price);
	}
}
