package com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.CustomerDaoImpl;
import com.dao.impl.RoleDaoImpl;
import com.model.Customer;
import com.model.PermissionBusiModel;
import com.model.Role;
import com.service.UserService;
import com.utils.AppException;

/**
 * Access page of user permission list
 */
public class ToModifyCustomer extends HttpServlet{

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
			
			// Forward to permission configuration page
			
			try {
				int cid=Integer.parseInt(request.getParameter("conId"));
				request.setAttribute("cid", cid);
				Customer customer=customerdao.getById(cid);
				request.setAttribute("customer", customer);
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/ToModifyCustomer.jsp").forward(
					request, response);
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




