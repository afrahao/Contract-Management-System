package com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.RoleDaoImpl;
import com.model.PermissionBusiModel;
import com.model.Role;
import com.service.UserService;
import com.utils.AppException;

/**
 * Access page of user permission list
 */
public class EditRole extends HttpServlet{

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
		
		// If user is not login, jump to login page
		if (userId == null) {
			response.sendRedirect("toLogin");
		}else {
			
			try {
				// nitialize userService
				UserService userService = new UserService();
				RoleDaoImpl roledao=new RoleDaoImpl();
				// Initialize roleList
				

				// Save roleList to request
				int roleId = Integer.parseInt(request.getParameter("roleId"));
				
				Role role=roledao.getById(roleId);
				request.setAttribute("role", role);
				// Forward to permission configuration page
				request.getRequestDispatcher("/EditRole.jsp").forward(
						request, response);
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

