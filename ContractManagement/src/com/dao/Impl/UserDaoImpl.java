package com.ruanko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruanko.dao.UserDao;
import com.ruanko.model.User;
import com.ruanko.utils.AppException;
import com.ruanko.utils.DBUtil;

/**
 * User data access layer implementation class
 */
public class UserDaoImpl implements UserDao {

	/**
	 *  Verify whether exists users that have the same name
	 * 
	 * @param name User name
	 * @return  Return true if there are users with same name,otherwise return false 
	 * @throws AppException
	 */
	public boolean isExist(String name) throws AppException {
		Connection conn = null; // Define Connection object
		PreparedStatement psmt = null;// Define PreparedStatement object
		ResultSet rs = null;// Define ResultSet object

		boolean flag = false;// Operation flag
		try {
			conn = DBUtil.getConnection();// Create database connection
			// Declare operation statement, query records based on user name, "?" is a placeholder
			String sql = "select id from t_user where name = ? and del = 0";

			psmt = conn.prepareStatement(sql);//  Pre-compiled sql
			psmt.setString(1, name);// Set values for the placeholder 

			rs = psmt.executeQuery();// Execute the query, return the query results
			if (rs.next()) {// Determine whether there are values in ResultSet
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(
					"com.ruanko.dao.impl.UserDaoImpl.isExist");
		} finally {
			DBUtil.closeResultSet(rs);// Close ResultSet object
			DBUtil.closeStatement(psmt);//  Close PreparedStatement object 
			DBUtil.closeConnection(conn);// Close Connection object
		}
		return flag;
	}

	/**
	 * Save user information
	 * 
	 * @param User object
	 * @return Return true if saved successfully,otherwise return false
	 * @throws AppException
	 */
	public boolean add(User user) throws AppException {
		Connection conn = null; // Define Connection object
		PreparedStatement psmt = null;// Define PreparedStatement object
		
		boolean flag = false;// Operation flag
		int result = -1;
		try {
			conn = DBUtil.getConnection();// Create database connection
			// Declare operation statement,save user information into database, "?" is a placeholder
			String sql = "insert into t_user (name,password)"
					+ " values (?,?)";
			
			psmt = conn.prepareStatement(sql);// Pre-compiled sql
			// Set values for the placeholder 
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPassword());

			result = psmt.executeUpdate();// Execute the update operation,return the affected rows
			if (result > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.ruanko.dao.impl.UserDaoImpl.add");
		} finally {
			DBUtil.closeStatement(psmt);//  Close PreparedStatement object 
			DBUtil.closeConnection(conn);// Close Connection obje
		}
		return flag;
	}
	
	/**
	 * Query user id according to the user name and password
	 * 
	 * @param name 
	 * @param password 
	 * @return User id
	 * @throws AppException
	 */
	public int login(String name, String password) throws AppException {
		int userId = -1; // Initialize the user id
		//Declare Connection object,PreparedStatement object and ResultSet object
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare operation statement:query user id according to the user name and password , "?" is a placeholder
			String sql = "select id from t_user where name = ? and password = ? and del = 0";
			// pre-compiled sql
			psmt = conn.prepareStatement(sql);
			// Set values for the placeholder
			psmt.setString(1, name);
			psmt.setString(2, password);
			// Execute the query operation
			rs = psmt.executeQuery();
			// Query record and extract the user id
			if (rs.next()) {
				userId = rs.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.ruanko.dao.impl.UserDaoImpl.login");
		} finally {
			// Close the database operation object, release resources
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return userId;
	}
}
