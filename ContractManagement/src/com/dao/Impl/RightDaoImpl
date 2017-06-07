package com.ruanko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruanko.dao.RightDao;
import com.ruanko.utils.AppException;
import com.ruanko.utils.DBUtil;

/**
 * Permission data access layer implementation class
 */
public class RightDaoImpl implements RightDao {

	/**
	 * Get role id according to user id
	 * 
	 * @param userId 
	 * @return roleId 
	 * @throws AppException
	 */
	public int getRoleIdByUserId(int userId) throws AppException {
		int roleId = -1; // Initialize roleId
		//Declare Connection object,PreparedStatement object and ResultSet object
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare operation statement,query roleId based on useId, "?" is a Placeholder
			String sql = "select role_id "
					+"from t_right "
					+"where user_id = ? and del = 0";
			// Pre-compiled sql
			psmt = conn.prepareStatement(sql);
			// Set values for the placeholder '?'
			psmt.setInt(1, userId);
			// Query result set
			rs = psmt.executeQuery();
			
			// Assigned the queried role id to roleId
			if (rs.next()) {
				roleId = rs.getInt("role_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.ruanko.dao.impl.RightDaoImpl.getRoleIdByUserId");
		} finally {
			// Close the database operation object, release resources
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return roleId;
	}

}
