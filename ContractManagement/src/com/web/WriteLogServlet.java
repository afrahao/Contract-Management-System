package com.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.impl.LogManagementDaoImpl;
import com.model.*;
import com.service.*;
import com.utils.*;
public class WriteLogServlet extends HttpServlet{


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogManagementDaoImpl write = new LogManagementDaoImpl();
		try {
			write.writeFile();
		} catch (AppException e) {
			e.printStackTrace();
		}
	}
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
