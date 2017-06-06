package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		this.doGet(request, response);
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.getRequestDispatcher("/index.jsp")
		.forward(request, response);
	}
}
