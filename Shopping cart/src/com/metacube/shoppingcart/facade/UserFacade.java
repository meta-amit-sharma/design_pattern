package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.metacube.shoppingcart.dao.EntityType;
import com.metacube.shoppingcart.dao.InMemoryUserDao;
import com.metacube.shoppingcart.dao.Factory;
import com.metacube.shoppingcart.dao.DataBase;
import com.metacube.shoppingcart.dao.OperationStatus;
import com.metacube.shoppingcart.entity.User;

public class UserFacade {
private static UserFacade obj;
	
	InMemoryUserDao objectDao =(InMemoryUserDao) Factory.getInstance(EntityType.User, DataBase.InMemory);
	
	public static UserFacade getInstance() {
		if (obj == null) {
			obj = new UserFacade();
		}
		
		return obj;
	}
	
	private UserFacade() {}
	
	public List<User> getAll(){
		List<User> list = new ArrayList<>();
		for(Entry<String, User> e: objectDao.getAll().entrySet()){
			list.add((User)e.getValue());
		}
		return list;
	}
    public boolean checkUser(String uid){
    	return objectDao.getAll().containsKey(uid);
    }
	public OperationStatus addUser(User item) {
		if(!objectDao.getAll().containsKey(item.getUserid())){
			objectDao.addUser(item);
			return OperationStatus.User_added;
		} else {
			return OperationStatus.Duplicate_User_Exist;
		}
			
	}
	
	public OperationStatus removeUser(String userId) {
		if( objectDao.getAll().containsKey(userId) ){
			objectDao.removeUser(userId);
			return OperationStatus.User_removed;
		} else {
			return OperationStatus.No_such_User_found;
		}
	}
	
	public OperationStatus updateUser(String userId, String userName, String password ){
		if(objectDao.getAll().containsKey(userId)){
			objectDao.updateUser(userId, userName, password);
			return OperationStatus.Update_successfull;
		} else {
			return OperationStatus.No_such_product_found;
		}
	}
}
