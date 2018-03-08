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

/**
 * All the business logic for the user resides here
 * (Singleton class)
 * 
 * @author Amit Sharma 
 *
 */
public class UserFacade {
	private static UserFacade obj;
	
	InMemoryUserDao objectDao =(InMemoryUserDao) Factory.getInstance(EntityType.User, DataBase.InMemory);
	//Singleton object creation
	public static UserFacade getInstance() {
		if (obj == null) {
			obj = new UserFacade();
		}
		
		return obj;
	}
	
	private UserFacade() {}
	//ends
	
	/**
	 * Function to return all the users in a list
	 * @return
	 */
	public List<User> getAll(){
		List<User> list = new ArrayList<>();
		for(Entry<String, User> e: objectDao.getAll().entrySet()){
			list.add((User)e.getValue());
		}
		return list;
	}
	
	/**
	 * Performs a check if the user exists
	 * @param uid
	 * @return
	 */
    public boolean checkUser(String uid){
    	return objectDao.getAll().containsKey(uid);
    }
    
    /**
     * Add a new user in the memory
     * @param user
     * @return
     */
	public OperationStatus addUser(User user) {
		if(!objectDao.getAll().containsKey(user.getUserid())){
			objectDao.addUser(user);
			return OperationStatus.User_added;
		} else {
			return OperationStatus.Duplicate_User_Exist;
		}
			
	}
	
	/**
	 * Removes the user with given Id from the memory
	 * @param userId
	 * @return
	 */
	public OperationStatus removeUser(String userId) {
		if( objectDao.getAll().containsKey(userId) ){
			objectDao.removeUser(userId);
			return OperationStatus.User_removed;
		} else {
			return OperationStatus.No_such_User_found;
		}
	}
	
	/**
	 * Updates the name and password of the user with 
	 * given UserId
	 * @param userId
	 * @param userName
	 * @param password
	 * @return
	 */
	public OperationStatus updateUser(String userId, String userName, String password ){
		if(objectDao.getAll().containsKey(userId)){
			objectDao.updateUser(userId, userName, password);
			return OperationStatus.Update_successfull;
		} else {
			return OperationStatus.No_such_product_found;
		}
	}
}
