package com.web;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;


public class AddUserServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		boolean ifRegister = false;
		//get userName and userPassword
		String userPassword = request.getParameter("password");
		String userName = request.getParameter("name");
		String wrongMessage = "";
		try {
			User myuser = new User();
			UserService myuserService = new UserService();
			//set the user's userName and userPassword
			myuser.setName(userName);
			myuser.setPassword(userPassword);
			ifRegister = myuserService.register(myuser);
			// Registration Successful
			if (ifRegister) 
			{
				wrongMessage = "Success register";
				//send the wrong wrongMessage
				request.setAttribute("message", wrongMessage);
				request.getRequestDispatcher("/AddUser.jsp").forward(request,response);
			}
			// Registration failed
			else 
			{ 
				wrongMessage = "Failed to register";
				//send wrong message
				request.setAttribute("message", wrongMessage);
				request.getRequestDispatcher("/AddUser.jsp").forward(request,response);
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
