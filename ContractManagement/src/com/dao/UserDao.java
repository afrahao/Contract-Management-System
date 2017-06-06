package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
	public boolean isExist(String name);
	
	/*
	  Save user's information
	 */
	public boolean add(User user);
	
	/*
	  Query  UserId according to user name and password
	 */
	public int login(String name,String password);
	
	/*
	  Query user's information according to id
	 */
	public User getById(int id);
	
	/*
	  Query user id set
	 */
	public List<Integer> getIds();
	
}
