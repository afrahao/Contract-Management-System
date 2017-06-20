package com.dao;

import java.util.List;

import com.model.Role;
import com.utils.AppException;


public interface RoleDao {

	//get role
	public Role getById(int id) throws AppException;
	
	//get all role
	public List<Role> getAll() throws AppException;
	
}
