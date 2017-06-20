package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.impl.CustomerDaoImpl;

public class DeleteCustomer extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		CustomerDaoImpl customerdao=new CustomerDaoImpl();
		//let user login if not
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			//delete customer
			customerdao.deleteCustomer(Integer.parseInt(request.getParameter("conId")));
			//turn to jsp
			response.sendRedirect("customerList.jsp");
		}
	}
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

}
