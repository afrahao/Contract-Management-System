package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ToAddCustomer extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		// I hate someone that not login....let the user login
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			
			//turn to page 'addcustomer'
			request.getRequestDispatcher("/AddCustomer.jsp").forward(
					request, response);
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}



