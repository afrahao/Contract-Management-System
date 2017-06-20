package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ToNewUserServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		// let user login
		if (userId == null)
		{
			response.sendRedirect("toLogin");
		}else {
			// turn to the user page
			request.getRequestDispatcher("/NewUser.jsp").forward(request, response);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
