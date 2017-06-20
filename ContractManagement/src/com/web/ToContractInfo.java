package com.web;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.impl.ContractDaoImpl;
import com.model.*;
import com.service.*;
import com.utils.*;
public class ToContractInfo extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		//let user login if it didn't
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			
			
			try {
				ContractDaoImpl contractdao=new ContractDaoImpl();
				//get all the contract list
				List<Contract> contractList=contractdao.getAll();
				request.setAttribute("contractList", contractList);
			} 
			catch (AppException e) 
			{
				e.printStackTrace();
			}
			//turn to page contract information
			request.getRequestDispatcher("/ContractInfo.jsp").forward(request, response);
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
