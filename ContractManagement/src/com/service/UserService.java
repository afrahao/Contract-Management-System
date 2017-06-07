package com.ruanko.service;

import com.ruanko.dao.RightDao;
import com.ruanko.dao.RoleDao;
import com.ruanko.dao.UserDao;
import com.ruanko.dao.impl.RightDaoImpl;
import com.ruanko.dao.impl.RoleDaoImpl;
import com.ruanko.dao.impl.UserDaoImpl;
import com.ruanko.model.Role;
import com.ruanko.model.User;
import com.ruanko.utils.AppException;

/**
 * User business logic class
 */
public class UserService {

	private UserDao userDao = null;//  Define a userDao interface object
	private RoleDao roleDao = null;// Define a roleDao interface object
	private RightDao rightDao = null;// Define a userDao rightDao object

	/**
	 * No-arg constructor method is used to initialize instance in data access layer
	 */
	public UserService() {
		userDao = new UserDaoImpl();
		roleDao = new RoleDaoImpl();
		rightDao = new RightDaoImpl();
	}

	/**
	 *User registration
	 * @param user User object
	 * @return Return true if registration is successful, otherwise return false
	 * @throws AppException
	 */
	public boolean register(User user) throws AppException {
		boolean flag = false;//  Define flag 
		try {
			if (!userDao.isExist(user.getName())) {// Execute save operation when the user does not exist
				flag = userDao.add(user);// Return the operation result back to flag
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("com.ruanko.service.UserService.register");
		}
		return flag;
	}
	
	/**
	 * User login
	 * 
	 * @param name 
	 * @param password 
	 * @return Query the matched user id according to the condition , otherwise it returns 0
	 * @throws AppException
	 */
	public int login(String name, String password) throws AppException {
		int userId = -1; // Declare userId
		try {
			//Get userId
			userId = userDao.login(name, password); 
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("com.ruanko.service.UserService.login");
		}
		// Return userId
		return userId;
	}
	
	/**
	 * Get the role information that corresponding to the user
	 * 
	 * @param userId 
	 * @return Role object
	 * @throws AppException
	 */
	public Role getUserRole(int userId) throws AppException {	
		Role role = null;// Declare role
		int roleId = -1; // Initialize  roleId
		try {
			//  Get the roleId that corresponding to the user
			roleId = rightDao.getRoleIdByUserId(userId);
			if(roleId > 0){
				// Get role information
				role = roleDao.getById(roleId); 
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("com.ruanko.service.UserService.getUserRole");
		}
		return role;
	}
}
