package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingcart.entity.User;
/**
 * In memory storage type DAO to perform operations on Users
 * 
 * @author Amit Sharma 
 *
 */
public class InMemoryUserDao implements BaseDao {
	
	Map<String , User> allUsers = new HashMap<>();

	/**
	 * returns the list of all users
	 * @return
	 */
	public Map<String, User> getAll() {
		return this.allUsers;
	}

	/**
	 * adds the user to the list
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		this.allUsers.put(user.getUserid(), user);
		
	}
	
	/**
	 * removes the user from the list
	 * 
	 * @param userID
	 */
	public void removeUser(String userID) {
		allUsers.remove(userID);
	}

	/**
	 * Updates the details of the existing user
	 * 
	 * @param userID
	 * @param userName
	 * @param password
	 */
	public void updateUser(String userID, String userName, String password) {
		User user = allUsers.get(userID);
		user.setName(userName);
		user.setPassword(password);
	}
}
