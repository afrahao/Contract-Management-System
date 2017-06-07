package com.ruanko.dao;

import com.ruanko.utils.AppException;

/**
 * Permission Data Access Layer Interface
 */
public interface RightDao {

	/**
	 * Get role id according to the userId
	 * 
	 * @param userId  
	 * @return roleId  
	 * @throws AppException
	 */
	public int getRoleIdByUserId(int userId) throws AppException;
	
}
