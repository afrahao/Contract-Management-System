package com.ruanko.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DBUtil {

	private static String url="jdbc:mysql://127.0.0.1:3306/contractdb?useUnicode=true&amp;"+"characterEncoding=utf8";//数据库连接字符串
	private static String user="root";//数据库帐号
	private static String password="03281234";//数据库密码
	
	public static Connection getConnection(){
		Connection conn=null;
		
		try{
			conn=DriverManager.getConnection(url,user,password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection(Connection conn){
		try{
			if((conn!=null)&&(!conn.isClosed())){
				conn.close();
				conn=null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void closeStateMent(Statement st){
		try{
			if((st!=null)&&(!st.isClosed())){
				st.close();
				st=null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void closeResultSet(ResultSet rs){
		try{
			if((rs!=null)&&(!rs.isClosed())){
				rs.close();
				rs=null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void main(String []args){
		Connection conn=null;
		conn=getConnection();
		if(conn!=null){
			System.out.println("aa");
		}
	}
}
