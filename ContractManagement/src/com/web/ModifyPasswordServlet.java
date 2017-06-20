package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Role;
import com.model.User;
import com.service.UserService;
import com.utils.AppException;

/**
 * Login Servlet
 */
public class ModifyPasswordServlet extends HttpServlet {

	/**
	 *  Process the POST login request
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set request's character encoding
		request.setCharacterEncoding("UTF-8");
		//  Get login information
	
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		String message = "";
		

		// Initialize the user business logic class
		UserService userService = new UserService();
		// Call business logic layer for user login
		try {
			if(userService.ModifyPassword(id, password))
			{
				response.sendRedirect("modifyUser");
			}
			else 
			{// Login failed
				// Set prompt message
				message = "Modify failed!";
				request.setAttribute("message", message); // Save prompt message into request
				// Save user name into request
				request.getRequestDispatcher("/ModifyPassword.jsp").forward(request,
						response);
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
