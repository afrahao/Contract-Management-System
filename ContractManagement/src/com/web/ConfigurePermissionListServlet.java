package com.web;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class ConfigurePermissionListServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get the user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		//let the user login if it not login
		if (userId == null)
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			
			try {
				UserService userService = new UserService();
				List<PermissionBusiModel> permissionList = new ArrayList<PermissionBusiModel>();
				//get the permission list
				permissionList = userService.getPermissionList();
				request.setAttribute("permissionList", permissionList);
				request.getRequestDispatcher("/ConfigurePermissionList.jsp").forward(request, response);
			} 
			catch (AppException e) 
			{
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
