package com.web;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class ModifyUserServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		//let user login if not
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{	
			try {
				UserService userService = new UserService();
				List<User> userList = new ArrayList<User>();
				//the operator role
				int RoleId = 2;
				// get operator list
				userList = userService.getUserListByRoleId(RoleId);
				// show operator list to jsp
				request.setAttribute("userList", userList);
				//turn to jsp
				request.getRequestDispatcher("/ModifyUser.jsp").forward(request, response);
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
