package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ConProcess;
import com.service.ContractService;
import com.service.UserService;
import com.utils.AppException;
import com.utils.Constant;

/**
 * Servlet for assigning contract
 */
public class DeleteUserServlet extends HttpServlet {

	/**
	 * Process result of assign contrct
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set the request's character encoding
		request.setCharacterEncoding("UTF-8");
		
		// Declare session
		HttpSession session = null;
		// Get session by using request
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// If user is not login, jump to login page
		if (userId == null) {
			response.sendRedirect("toLogin");
		}
		
		
		String[] hqht = request.getParameterValues("choosenUser");

		try {
			//  Initialize contractService
			UserService userService = new UserService();
			/*
			 * Call business logic layer to distributed contract
			 */ 
			// Assigned cuntersign people
			for (String hq : hqht) {
				userService.DeleteUser(Integer.parseInt(hq.toString()));
			}
		
			request.getRequestDispatcher("/toDeleteUser").forward(request,
					response);
		} catch (AppException e) {
			e.printStackTrace();
			// Redirect to exception page
			response.sendRedirect("toError");
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
