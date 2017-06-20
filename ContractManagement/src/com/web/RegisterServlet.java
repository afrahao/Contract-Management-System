package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;
import com.utils.AppException;

/**
 * Servlet for registration
 */
public class RegisterServlet extends HttpServlet {

	/**
	 * Process the register request
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Set the request's character encoding
		request.setCharacterEncoding("UTF-8");
		// Get registration information 
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		// Declare operation flag
		boolean flag = false;
		// Initialize the prompt message 
		String message = "";
		/*
		 * Call methods in business logic layer to process business logic 
		 */
		try {
			//Instantiate the entity class object User 
			User user = new User();
			// Initialize the user business logic class
			UserService userService = new UserService();
			// Encapsulate the user information to the user object
			user.setName(name);
			user.setPassword(password);
			// Call business logic layer for user registration 
			flag = userService.register(user);
			if (flag) { // Registration Successful
				// After registration Successful, redirect to the login page
				response.sendRedirect("toLogin");
			} else { // Registration failed
				// Set prompt message
				message = "Registration failed";
				request.setAttribute("message", message); // Save prompt message into request 
				// Forward to the registration page
				request.getRequestDispatcher("/register.jsp").forward(request,
						response);
			}
		} catch (AppException e) {
			e.printStackTrace();
			// Redirect to the exception page
			response.sendRedirect("toError");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
