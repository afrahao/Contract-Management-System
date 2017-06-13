package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.ConState;
import com.model.Customer;
import com.model.Role;
import com.utils.AppException;
import com.utils.DBUtil;

public class CustomerDaoImpl {
	public List<Customer> getAll() throws AppException {
		// Initialiaze roleList
		List<Customer> customerList = new ArrayList<Customer>();
		
		//Declare Connection object,PreparedStatement object and ResultSet object
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare operation statement:query all role object set,"?" is a placeholder
			String sql = "select id,num,name,address,tel,fax,code,bank from t_customer ";
			
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();// Return result set
			// Loop to get information in result set,and save in ids
			while (rs.next()) {
				Customer customer = new Customer(); // Instantiate role object
				// Set value to role
				customer.setId(rs.getInt("id"));
				customer.setNum(rs.getString("num"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setTel(rs.getString("tel"));
				customer.setFax(rs.getString("fax"));
				customer.setCode(rs.getString("code"));
				customer.setBank(rs.getString("bank"));
				
				customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the database operation object, release resources
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return customerList;
	}
	public Customer getById(int id) throws AppException {
		// Initialiaze roleList
		Customer customer = new Customer();
		
		//Declare Connection object,PreparedStatement object and ResultSet object
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare operation statement:query all role object set,"?" is a placeholder
			String sql = "select id,num,name,address,tel,fax,code,bank,account from t_customer where id=?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();// Return result set
			// Loop to get information in result set,and save in ids
			while (rs.next()) {
				
				// Set value to role
				customer.setId(rs.getInt("id"));
				customer.setNum(rs.getString("num"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setTel(rs.getString("tel"));
				customer.setFax(rs.getString("fax"));
				customer.setCode(rs.getString("code"));
				customer.setBank(rs.getString("bank"));
				customer.setAccout(rs.getString("account"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the database operation object, release resources
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return customer;
	}
	public void modifyCustomer(Customer customer){
		//Declare Connection object,PreparedStatement object and ResultSet object
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare operation statement,query role's information based on role id, "?" is a placeholder
			String sql = "update t_customer " 
			+"set num= ?,name=?,address=?,tel=?,fax=?,code=?,bank=?,account=? "
					+"where id=? ";
			// Pre-compiled sql
			psmt =(PreparedStatement) conn.prepareStatement(sql);
			// Set values for the placeholder  '?'
			psmt.setString(1, customer.getNum());
			psmt.setString(2, customer.getName());
			psmt.setString(3, customer.getAddress());
			psmt.setString(4, customer.getTel());
			psmt.setString(5, customer.getFax());
			psmt.setString(6, customer.getCode());
			psmt.setString(7, customer.getBank());
			psmt.setString(8, customer.getAccout());
			psmt.setInt(9, customer.getId());
			rs = psmt.executeUpdate();
			
			// Save user's information by using Pole entity object when queried the results set 
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			// Close the database operation object, release resources
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		
	}
	public void addCustomer(Customer customer){
		//Declare Connection object,PreparedStatement object and ResultSet object
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs;
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare operation statement,query role's information based on role id, "?" is a placeholder
			String sql = "insert into t_customer " 
			+"(num,name,address,tel,fax,code,bank,account,del) "
					+"values"
					+"(?,?,?,?,?,?,?,?,0)";
			// Pre-compiled sql
			psmt =(PreparedStatement) conn.prepareStatement(sql);
			// Set values for the placeholder  '?'
			psmt.setString(1, customer.getNum());
			psmt.setString(2, customer.getName());
			psmt.setString(3, customer.getAddress());
			psmt.setString(4, customer.getTel());
			psmt.setString(5, customer.getFax());
			psmt.setString(6, customer.getCode());
			psmt.setString(7, customer.getBank());
			psmt.setString(8, customer.getAccout());
			rs = psmt.executeUpdate();
			
			// Save user's information by using Pole entity object when queried the results set 
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			// Close the database operation object, release resources
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		
	}
	public void deleteCustomer(int id){
		//Declare Connection object,PreparedStatement object and ResultSet object
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs;
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare operation statement,query role's information based on role id, "?" is a placeholder
			String sql = "delete from t_customer where id =? " ;
			// Pre-compiled sql
			psmt =(PreparedStatement) conn.prepareStatement(sql);
			// Set values for the placeholder  '?'
			psmt.setInt(1, id);
			
			rs = psmt.executeUpdate();
			
			// Save user's information by using Pole entity object when queried the results set 
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			// Close the database operation object, release resources
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		
	}
	public boolean isExist(String name) throws AppException {
		Connection conn = null; // Define database connection object
		PreparedStatement psmt = null;// Define PreparedStatement object
		ResultSet rs = null;// Define ResultSet object

		boolean flag = false;// Operation flag
		try {
			conn = DBUtil.getConnection();// Create database connection
			// Declare operation statement, query records based on user name, "?" is a placeholder
			String sql = "select id from t_customer where name = ? and del = 0";

			psmt = conn.prepareStatement(sql);//  Pre-compiled sql
			psmt.setString(1, name);// Set values for the placeholder 

			rs = psmt.executeQuery();// Execute the query, return the query results
			if (rs.next()) {// Determine whether there are values in results set
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.closeResultSet(rs);// Close database query result set
			DBUtil.closeStatement(psmt);//  Close database object pretreatment
			DBUtil.closeConnection(conn);// Close database connection object
		}
		return flag;
	}

	
}
