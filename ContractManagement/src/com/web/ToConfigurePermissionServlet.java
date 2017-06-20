package com.web;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.model.*;
import com.service.*;
import com.utils.*;

public class ToConfigurePermissionServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		//let user login if it didn't
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{

			//get user id,name and current role
			int uId = Integer.parseInt(request.getParameter("userId"));
			String userName = (String)request.getParameter("uName");
			int roleId = Integer.parseInt(request.getParameter("roleId"));
			
			//create a permission business
			PermissionBusiModel permission = new PermissionBusiModel();
			permission.setUserId(uId);
			permission.setUserName(userName);
			permission.setRoleId(roleId);
			
			// send permission to jsp
			request.setAttribute("permission", permission);
			
			try 
			{
				UserService userService = new UserService();
				List<Role> roleList = new ArrayList<Role>();
				//get the exist role list
				roleList = userService.getRoleList();

				// Send roleList to jsp
				request.setAttribute("roleList", roleList);
				// turm to page permission configuration
				request.getRequestDispatcher("/ConfigurePermission.jsp").forward(request, response);
			} 
			catch (AppException e)
			{
				e.printStackTrace();
				// Redirect to the exception page
				response.sendRedirect("toError");
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		this.doPost(request, response);
	}
}
