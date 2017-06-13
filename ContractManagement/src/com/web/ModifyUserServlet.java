package com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ConBusiModel;
import com.model.User;
import com.service.ContractService;
import com.service.UserService;
import com.utils.AppException;

/**
 * Access page of contract to be signed
 */
public class ModifyUserServlet extends HttpServlet{

	/**
	 *Jump to page of contract to be signed
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		// Set the request's character encoding
		request.setCharacterEncoding("UTF-8");
		
		// Declare session
		HttpSession session = null;
		//  Get session by using request
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// If user is not login, jump to login page
		if (userId == null) {
			response.sendRedirect("toLogin");
		}else {
			
			try {
				//Initialize contractService
				UserService userService = new UserService();
				// Initialize contractList
				List<User> userList = new ArrayList<User>();
				int RoleId = 2;
				// Call business logic layer to get list of contract to be signed
				userList = userService.getUserListByRoleId(RoleId);
				// Save contractList to request
				request.setAttribute("userList", userList);
				// Forward to contract to be signed page
				request.getRequestDispatcher("/ModifyUser.jsp").forward(request, response);
			} catch (AppException e) {
				e.printStackTrace();
				// Redirect to the exception page
				response.sendRedirect("toError");
			}
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
