package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingcart.entity.User;

public class InMemoryUserDao implements BaseDao {
		
		Map<String , User> allUsers = new HashMap<>();

		public Map<String, User> getAll() {
			return this.allUsers;
		}

		public void addUser(User user) {
			this.allUsers.put(user.getUserid(), user);
			
		}
		
		public void removeUser(String userId) {
			allUsers.remove(userId);
		}

		public void updateUser(String userId, String userName, String password) {
			User user = allUsers.get(userId);
			user.setName(userName);
			user.setPassword(password);
		}
		
	

}
