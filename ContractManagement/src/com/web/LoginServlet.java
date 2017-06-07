package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UserService;

public class LoginServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//get the information user input
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		// Initialize userId
		int userId = -1;
		// Initialize prompt message
		String message = "";
		
		// Initialize the user business logic class
		UserService userService = new UserService();
		// Call business logic layer for user login
		userId = userService.login(name, password);
		if (userId > 0) { // login successfully  
			//  Declare session
			HttpSession session = null;
			// Get session by using request
			session = request.getSession();
			// Save userId and user name into session
			session.setAttribute("userId", userId);
			session.setAttribute("userName", name);
			request.getRequestDispatcher("/MainFrame.jsp").forward(request,response);
			
		} else {// Login failed
			// Set prompt message
			message = "Incorrect user name or password!";
			request.setAttribute("message", message); // Save prompt message into request
			// Save user name into request
			request.setAttribute("userName", name);	
			// Forward to login page
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Call doPost() to process request
		this.doPost(request, response);
	}
} 
