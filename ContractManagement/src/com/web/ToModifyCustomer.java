package com.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.impl.CustomerDaoImpl;
import com.model.*;
import com.utils.*;

public class ToModifyCustomer extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		CustomerDaoImpl customerdao=new CustomerDaoImpl();
		// let user login if it didn't login
		if (userId == null)
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			try {
				int cid=Integer.parseInt(request.getParameter("conId"));
				request.setAttribute("cid", cid);
				Customer customer=customerdao.getById(cid);
				request.setAttribute("customer", customer);
			} 
			catch (AppException e)
			{
				e.printStackTrace();
			}
			request.getRequestDispatcher("/ToModifyCustomer.jsp").forward(
					request, response);
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}




