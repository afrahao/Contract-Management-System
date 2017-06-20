package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.service.*;
import com.utils.*;

public class ModifyPasswordServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		//get user id and password
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		String message = "";
		UserService userService = new UserService();
		//let the user login if not
		try {
			//modify password
			if(userService.ModifyPassword(id, password))
			{
				response.sendRedirect("modifyUser");
			}
			//modify failed
			else 
			{
				message = "Modify failed!";
				request.setAttribute("message", message);
				//sent message and turn to jsp
				request.getRequestDispatcher("/ModifyPassword.jsp").forward(request,
						response);
			}
		} catch (AppException e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		this.doPost(request, response);
	}
}
