package com.metacube.shoppingcart.dao;



public class Factory{
	
	private static BaseDao obj;
	public static BaseDao getInstance(EntityType objtyp, DataBase dbName) {
		if(dbName == DataBase.InMemory){
			switch(objtyp){
				case Product : obj = new InMemoryProductDao();
							return obj;
				case User : obj = new InMemoryUserDao();
							return obj;
				case Cart : obj = new InMemoryCartDao();
							return obj;
			}
		}
	return null;	
	}
	private Factory() {}
	
	
	

	
}
