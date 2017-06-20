package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class IndexServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		this.doGet(request, response);
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		//turn to jsp
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
