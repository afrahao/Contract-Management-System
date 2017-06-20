package com.web;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.model.*;
import com.service.*;
import com.utils.*;
public class ToRoleList extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			
			try {
				// nitialize userService
				UserService userService = new UserService();
				// Initialize roleList
				List<Role> roleList = new ArrayList<Role>();
				// Call business logic layer to get all role list
				roleList = userService.getRoleList();

				// Save roleList to request
				request.setAttribute("roleList", roleList);
				// Forward to role list page
				request.getRequestDispatcher("/roleList.jsp").forward(
						request, response);
			} catch (AppException e) {
				e.printStackTrace();
				response.sendRedirect("toError");
			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
