package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.model.Contract;
import com.model.User;
import com.service.ContractService;
import com.utils.AppException;

/**
 * Servlet of accessing sign page
 */
public class ToModifyPasswordServlet extends HttpServlet {

	/**
	 * Jump to sign page
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set the request's character encoding
		request.setCharacterEncoding("UTF-8");
		
		// Declare session
		HttpSession session = null;
		// Get session by using request object
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// If the user is not login, then jump to login page
		if (userId == null) {
			response.sendRedirect("toLogin");
		} else {

			// Get contract id
			String name = request.getParameter("userName");
			String Id = request.getParameter("userId");
			User user = new User();
			user.setName(name);
			user.setId(Integer.parseInt(Id.toString()));
			user.setDel(0);
			
			
			// Save contract to request
			request.setAttribute("user", user);
			// Forward to sign page
			request.getRequestDispatcher("/ModifyPassword.jsp").forward(
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
