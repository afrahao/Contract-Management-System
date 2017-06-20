package com.dao;

import java.util.List;

import com.model.User;
import com.utils.AppException;


public interface UserDao {
	
	//judge if there if the user
	public boolean isExist(String name) throws AppException;
	//judge if there if the user
	public boolean isExist(int id) throws AppException;
	//add user
	public boolean add(User user) throws AppException;
	//delete user
	public boolean delete(int id) throws AppException;
	//login
	public int login(String name,String password) throws AppException;
	//get user
	public User getById(int id) throws AppException;
	//get contract id
	public List<Integer> getIds() throws AppException;	
	//modify password
	public boolean modify(int id, String password) throws AppException;
	//judge if there is the user
	public boolean isExistUser(String name) throws AppException;
	//judge if the password user enter is correct
	public boolean isSame(String name, String oPassword) throws AppException;
	//change the password
	public boolean ChangePassword(String name, String nPassword) throws AppException;
	
}
