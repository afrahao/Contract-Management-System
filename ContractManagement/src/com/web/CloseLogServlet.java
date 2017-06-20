package com.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.impl.*;
import com.utils.*;

public class CloseLogServlet  extends HttpServlet implements ServletContextListener{
	
	public void contextDestroyed(ServletContextEvent arg0)
	{
		LogManagementDaoImpl op = new LogManagementDaoImpl();
		try {
			//set the log close when the server closed
			op.setChoose("0");
		} catch (AppException e) {
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) 
	{
		
	}
}
