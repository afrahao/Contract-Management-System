package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class ConfigurePermissionServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		//let the user login if not
		if (userId == null)
		{
			response.sendRedirect("toLogin");
		} 
		else
		{
			//get id and role id
			int uId = Integer.parseInt(request.getParameter("userId").toString());
			int roleId = Integer.parseInt(request.getParameter("roleId").toString());
			Right right = new Right();
			right.setUserId(uId);
			right.setRoleId(roleId);
			
			try 
			{
				UserService userService = new UserService();
				userService.assignPermission(right);
				//show the permission list to jsp
				response.sendRedirect("configurePermissionList");
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
