package com.dao;

import java.util.List;

import com.model.Right;
import com.utils.AppException;


public interface RightDao {

	//get role id by user if
	public int getRoleIdByUserId(int userId) throws AppException;
	
	//get user id by role id
	public List<Integer> getUserIdsByRoleId(int roleId) throws AppException;
	
	//get permission id by user id
	public int getIdByUserId(int userId) throws AppException;
	
	//Update contract content according to permission id,pass parameter though entity object
	public boolean updateById(Right right) throws AppException;
	
	//add right
	public boolean add(Right right) throws AppException;
	
}
