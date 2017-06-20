package com.web;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.model.*;
import com.service.*;
import com.utils.*;

public class ToDeleteUserServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		//let user login
		if (userId == null) {
			response.sendRedirect("toLogin");
		}else {
			try {
			UserService userService = new UserService();
			int roleId = 2;
			List<User> userList = new ArrayList<User>();
			// get operator list
			userList = userService.getUserListByRoleId(roleId);
			
			//send user list to jsp
			request.setAttribute("userList", userList);
			// turn to jsp
			request.getRequestDispatcher("/DeleteUser.jsp").forward(request,
					response);
			}
			catch (AppException e) 
			{
				e.printStackTrace();
				response.sendRedirect("toError");
			}
		}
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		this.doPost(request, response);
	}
}
