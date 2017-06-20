package com.web;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.impl.CustomerDaoImpl;
import com.model.*;
import com.service.*;
import com.utils.*;

public class ModifyCustomer extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		CustomerDaoImpl customerdao=new CustomerDaoImpl();
		//let the user login if not
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			//get and set customer information
			Customer customer=new Customer();
			customer.setAccout(request.getParameter("account"));
			customer.setAddress(request.getParameter("address"));
			customer.setBank(request.getParameter("bank"));
			customer.setCode(request.getParameter("code"));
			customer.setDel(0);
			customer.setFax(request.getParameter("fax"));
			customer.setId(Integer.parseInt(request.getParameter("conId")));
			customer.setName(request.getParameter("name"));
			customer.setNum(request.getParameter("num"));
			customer.setTel(request.getParameter("tel"));
			//write customer information to database
			customerdao.modifyCustomer(customer);
			//turn to jsp
			response.sendRedirect("customerList.jsp");
		}
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

}
