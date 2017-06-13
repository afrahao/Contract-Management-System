package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.CustomerDaoImpl;
import com.dao.impl.RoleDaoImpl;
import com.model.Customer;
import com.model.Role;

public class AddCustomer extends HttpServlet{

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
		CustomerDaoImpl customerdao=new CustomerDaoImpl();
		// If user is not login, jump to login page
		if (userId == null) {
			response.sendRedirect("toLogin");
		}else {
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
	
	/**
	 * Process GET requests
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Call doPost() to process request
		this.doPost(request, response);
	}

}

