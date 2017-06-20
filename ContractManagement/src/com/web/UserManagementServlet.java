package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UserManagementServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// If the user is not login, then jump to login page
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			// Forwarded to user management page
			request.getRequestDispatcher("/UserManagement.jsp").forward(request, response);
		}
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
}
