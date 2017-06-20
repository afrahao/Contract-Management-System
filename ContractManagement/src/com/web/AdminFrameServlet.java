package com.web;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class AdminFrameServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{ 
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		Integer myId = (Integer)session.getAttribute("userId");
		
		//let the user login anyway
		if (myId == null)
		{
			response.sendRedirect("toLogin");
		}
		else 
		{
			request.getRequestDispatcher("/AdminFrame.jsp").forward(request, response);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		this.doPost(request, response);
	}
	
}
