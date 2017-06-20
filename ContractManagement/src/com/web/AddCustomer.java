package com.web;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.dao.impl.*;
import com.model.*;

public class AddCustomer extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		CustomerDaoImpl customerdao=new CustomerDaoImpl();
		// let the user login if he or she not login
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else 
		{
			//get the customer's information from the jsp
			Customer customer=new Customer();
			customer.setAccout(request.getParameter("account"));
			customer.setAddress(request.getParameter("address"));
			customer.setBank(request.getParameter("bank"));
			customer.setCode(request.getParameter("code"));
			customer.setDel(0);
			customer.setFax(request.getParameter("fax"));
			customer.setName(request.getParameter("name"));
			customer.setNum(request.getParameter("num"));
			customer.setTel(request.getParameter("tel"));
			customerdao.addCustomer(customer);
			response.sendRedirect("customerList.jsp");
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

}

