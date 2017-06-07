package com.ruanko.dao;

import com.ruanko.model.User;
import com.ruanko.utils.AppException;

/**
 * User Data Access Layer Interface
 */
public interface UserDao {
	
	/**
	 * Verify whether exists users that has the same name 
	 * 
	 * @param name User name
	 * @return Return true if there are users have same name,otherwise return false 
	 * @throws AppException
	 */
	public boolean isExist(String name) throws AppException;
	
	/**
	 * Save user information
	 * 
	 * @param user user object
	 * @return Return true if saved successfully,otherwise return false
	 * @throws AppException
	 */
	public boolean add(User user) throws AppException;
	
	/**
	 * Query user id according to the user name and password
	 * @param name 
	 * @param password 
	 * @return User id
	 * @throws AppException 
	 */
	public int login(String name,String password) throws AppException;
	
}
