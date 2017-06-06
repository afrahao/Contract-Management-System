package com.service;

import java.util.ArrayList;
import java.util.List;
import com.model.User;

import com.dao.UserDao;
import com.dao.UserDaoImpl;



public class UserService {

	private UserDao userDao = null;//  Define a userDao interface object

	
	public UserService() {
		userDao = new UserDaoImpl();
	}

	
	public boolean register(com.model.User user) {
		boolean flag = false;//  Define flag 
			if (!userDao.isExist(user.getName())) {// Execute save operation when the user does not exist
				flag = userDao.add(user);// Return the operation result back to flag
			}
		return flag;
	}
	
	
	public int login(String name, String password){
		int userId = -1; // Declare userId
			//Get userId
			userId = userDao.login(name, password); 
		// Return userId
		return userId;
	}
}	
