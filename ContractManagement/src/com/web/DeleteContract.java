package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.impl.*;


public class DeleteContract extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		ContractDaoImpl contractdao=new ContractDaoImpl();
		//let the user login if not
		if (userId == null)
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			//delete the contract
			contractdao.deleteContract((Integer.parseInt(request.getParameter("conId"))));
			response.sendRedirect("toTerminateContract");
		}
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

}
