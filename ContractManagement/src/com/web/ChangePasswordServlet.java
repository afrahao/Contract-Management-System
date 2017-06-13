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
public class ChangePasswordServlet extends HttpServlet {

	/**
	 * Process the register request
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Set the request's character encoding
		request.setCharacterEncoding("UTF-8");
		// Get registration information 
		String name = request.getParameter("name");
		String oPassword = request.getParameter("password");
		String nPassword = request.getParameter("password2");

		// Declare operation flag
		boolean flag = false;
		boolean flag1 = false;
		boolean flag2 = false;
		// Initialize the prompt message 
		String message = "";
		/*
		 * Call methods in business logic layer to process business logic 
		 */
		try {
			// Initialize the user business logic class
			UserService userService = new UserService();
			
			if(flag1 = userService.IsExist(name))
			{
				if(flag2 = userService.IsSame(name,oPassword))
				{
					flag = userService.ChangePassword(name,nPassword);
				}
			}
			if (flag && flag1 && flag2) { // Registration Successful
				// After registration Successful, redirect to the login page
				response.sendRedirect("toLogin");
			}
			else 
			{
				if(!flag)
				{ // Registration failed
				// Set prompt message
					message = "Change failed";
				}
				else if(!flag2)
				{
					// Set prompt message
					message = "The original password is not corret!";
				}
				else if(!flag1)
				{
					// Set prompt message
					message = "There is no such a user";
				}
				request.setAttribute("message", message); // Save prompt message into request 
				// Forward to the registration page
				request.getRequestDispatcher("/ChangeUser.jsp").forward(request,
						response);
			}
		} catch (AppException e) {
			e.printStackTrace();
			// Redirect to the exception page
			response.sendRedirect("toError");
		}
	}

	/**
	 * Process the GET requests
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Call doPost() to process request
		this.doPost(request, response);
	}
}
