package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;


public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response){
		//Set the request's character encoding
		try {
			request.setCharacterEncoding("UTF-8");
		// Get information 
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		boolean flag = false;
		// Initialize the message 
		String message = "";
			User user = new User();
			UserService userService = new UserService();
			// Encapsulate the user information to the user object
			user.setName(name);
			user.setPassword(password);
			// Call business logic layer
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
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Call doPost() to process request
		this.doPost(request, response);
	}
}
