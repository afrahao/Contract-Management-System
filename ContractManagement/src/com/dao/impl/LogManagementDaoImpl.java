package com.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.model.Contract;
import com.mysql.jdbc.Statement;
import com.utils.AppException;
import com.utils.DBUtil;

public class LogManagementDaoImpl {

	public LogManagementDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void openLog() throws AppException{
		//Declare Connection object,PreparedStatement object and ResultSet object
		Connection conn = null;
		Statement psmt = null;
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare operation statement,query role's information based on role id, "?" is a placeholder
			String sql = "set global log_output=file" ;
			String sql1 = "set global general_log_file = 'd://general.log'" ;
			String sql2 = "set global general_log=on" ;
			// Pre-compiled sql
			psmt =(Statement) conn.createStatement();
			psmt.addBatch(sql);
			psmt.addBatch(sql1);
			psmt.addBatch(sql2);
			
			psmt.executeBatch();
			psmt.clearBatch();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			// Close the database operation object, release resources
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
	}
	
	public void closeLog() throws AppException{
		//Declare Connection object,PreparedStatement object and ResultSet object
		Connection conn = null;
		Statement psmt = null;
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			String sql = "set global general_log=off" ;
			// Pre-compiled sql
			psmt =(Statement) conn.createStatement();
			psmt.addBatch(sql);
			
			psmt.executeBatch();
			psmt.clearBatch();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			// Close the database operation object, release resources
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}	
	}
	
	public String getChoose() throws AppException{
		// Declare contract
				Contract contract = null;
				
				// Declare database connection object, pre-compiled object and result set object
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				
				try {
					// Create database connection
					conn = DBUtil.getConnection();
					//Define SQL statement: query contract information according to the contract id 
					String sql = "select value from t_choose "
							+"where name='oper'";

					// Pre-compiled sql, and set the parameter values
					psmt = conn.prepareStatement(sql);
					
					// Query result set
					rs = psmt.executeQuery();

					//Get information in result set by loop,and encapsulated into contract object
					if(rs.next()) {
						return rs.getString("value");	
					}

				} catch (SQLException e) {
					e.printStackTrace();
					throw new AppException(
							"com.ruanko.dao.impl.LogManagement.getChoose");
				} finally {
					//  Close the database operation object
					DBUtil.closeResultSet(rs);
					DBUtil.closeStatement(psmt);
					DBUtil.closeConnection(conn);
				}
				return null;
	}
	
	public boolean setChoose(String value) throws AppException {
		boolean flag = false;// Operation flag
		// Declare database connection object, pre-compiled object
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare sql:update contract information according to contract id
			String sql = "update t_choose set value=? where name='oper'";

			// Pre-compiled sql, and set the parameter values
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, value);
			// Execute update,return affected rows
			int count = psmt.executeUpdate();
			
			if (count > 0) {// If affected lines greater than 0, so update success
				flag = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.ruanko.dao.impl.LogManagementDaoImpl.setChoose");
		} finally {
			// Close database operation object
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}
	
	public boolean writeLog(String content,int userId,Date time) throws AppException{
		boolean flag = false;// Operation flag
		// Declare database connection object, pre-compiled object and results set object
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// Create database connection
			conn = DBUtil.getConnection();
			// Declare sql:update operation status,content and time info of contract according to user id,contract id and operation type
			String sql = "insert into t_log(user_id,time,content,del) values (?,?,?,0)";

			// Pre-compiled sql, and set the value to parameter 
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userId);
			psmt.setString(3, content);

			// Date format is：yyyy-MM-dd hh:mm:ss     
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			java.sql.Timestamp Time = new Timestamp(time.getTime());
			df.format(Time); // Formatting time
			psmt.setTimestamp(2, Time);
			// Execute update, return the affected rows
			int count = psmt.executeUpdate();
			
			if (count > 0) {// If affected lines greater than 0, the update is successful
				flag = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.LogManagementDaoImpl.writeLog");
		} finally {
			// Close the database operation object 
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}
	
	public boolean writeFile() throws AppException {
		// Declare contract
				// Declare database connection object, pre-compiled object and result set object
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				
				try {
					// Create database connection
					conn = DBUtil.getConnection();
					//Define SQL statement: query contract information according to the contract id 
					String sql = "select id,user_id,time,content "
							+"from t_log";

					// Pre-compiled sql, and set the parameter values
					psmt = conn.prepareStatement(sql);
					
					// Query result set
					rs = psmt.executeQuery();

					File filename = new File("d://log.txt");
					if(filename==null)
					{
						filename.createNewFile();
					}
					BufferedWriter out = new BufferedWriter(new FileWriter(filename));
          while(rs.next()) {
						String output = rs.getString("user_id")+ " " + rs.getString("time")+ " " + rs.getString("content") +"  ";
						out.write(output);
					}
					if(out!=null)
					{
						out.close();
					}
				

				} catch (SQLException e) {
					e.printStackTrace();
					throw new AppException(
							"com.ruanko.dao.impl.ContractDaoImpl.getById");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					//  Close the database operation object
					DBUtil.closeResultSet(rs);
					DBUtil.closeStatement(psmt);
					DBUtil.closeConnection(conn);
				}
				return false;
	}
}
