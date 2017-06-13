package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.RoleDaoImpl;
import com.model.Role;

public class AddRole extends HttpServlet{

	/**
	 * Jump to page of user permission list
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		// Set character set of request to "UTF-8"
		request.setCharacterEncoding("UTF-8");
		
		// Declare session
		HttpSession session = null;
		// Get session by using request
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// If user is not login, jump to login page
		if (userId == null) {
			response.sendRedirect("toLogin");
		}else {
			String[] privlege=request.getParameterValues("check");
			String function;
			RoleDaoImpl roledao=new RoleDaoImpl();
			Role role=new Role();
			// Forward to permission configuration page
			role.setName(request.getParameter("name"));
			role.setDescription(request.getParameter("content"));
			role.setDel(0);
			function=privlege[0];
			for(int i=1;i<privlege.length;i++)
			{
				function=function+","+privlege[i];
			}
			role.setFuncIds(function);
			roledao.addRole(role);
			response.sendRedirect("roleList");
		}
	}
	
	/**
	 * Process GET requests
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Call doPost() to process request
		this.doPost(request, response);
	}

}
