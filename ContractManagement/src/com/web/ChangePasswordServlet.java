package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;


public class ChangePasswordServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		// get the user name, old password and new password
		String name = request.getParameter("name");
		String oPassword = request.getParameter("password");
		String nPassword = request.getParameter("password2");

		//if there is the user
		boolean isUser = false;
		//is the old password is the same as the user entered
		boolean isPassword = false;
		//if change the password successfully
		boolean isChange = false;
		String message = "";
		
		try {
			UserService userService = new UserService();
			
			if(isUser = userService.IsExist(name))
			{
				if(isPassword = userService.IsSame(name,oPassword))
				{
					isChange = userService.ChangePassword(name,nPassword);
				}
			}
			//change password successfully
			if (isUser && isPassword && isChange) {
				response.sendRedirect("toLogin");
			}
			else 
			{
				//set the reminding message
				if(!isChange)
				{
					message = "Change failed";
				}
				else if(!isPassword)
				{
					message = "The original password is not corret!";
				}
				else if(!isUser)
				{
					message = "There is no such a user";
				}
				request.setAttribute("message", message);
				request.getRequestDispatcher("/ChangeUser.jsp").forward(request,response);
			}
		}
		catch (AppException e) 
		{
			e.printStackTrace();
			response.sendRedirect("toError");
		}
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		this.doPost(request, response);
	}
}
