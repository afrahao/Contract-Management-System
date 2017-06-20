package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.impl.CustomerDaoImpl;
import com.model.*;
import com.utils.*;

public class CustomerDetail extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		// let user login if not
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		} else {

			// Get contract id
			int conId = Integer.parseInt(request.getParameter("conId"));

			try {
				CustomerDaoImpl customerdao=new CustomerDaoImpl();
				//get customer
				Customer customer= customerdao.getById(Integer.parseInt(request.getParameter("conId")));
				//send customer information to jsp
				request.setAttribute("customer", customer);
				//turn to jsp
				request.getRequestDispatcher("/CustomerDetail.jsp").forward(request, response);
			}
			catch (AppException e) 
			{
				e.printStackTrace();
				response.sendRedirect("toError");
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
