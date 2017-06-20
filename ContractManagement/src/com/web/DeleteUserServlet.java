package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.service.*;
import com.utils.*;

public class DeleteUserServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		// let user login if not
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			//get the chosen user
			String[] chosenUser = request.getParameterValues("choosenUser");

			try
			{
				UserService userService = new UserService();
				
				//get the delete user
				for (String chosen : chosenUser)
				{
					//delete users
					userService.DeleteUser(Integer.parseInt(chosen.toString()));
				}
				//turn to jsp
				request.getRequestDispatcher("/toDeleteUser").forward(request,response);
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
