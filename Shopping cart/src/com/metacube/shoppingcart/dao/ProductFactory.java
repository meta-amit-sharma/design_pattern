package com.metacube.shoppingcart.dao;



public class ProductFactory{
	
	private static BaseDao obj;
	public static BaseDao getInstance(db dbName) {
		switch(dbName){
		case InMemory : obj = new InMemoryProductDao();
						return obj;
		case Sql : return null;
		}
	return null;	
	}
	private ProductFactory() {}
	
	
	

	
}
