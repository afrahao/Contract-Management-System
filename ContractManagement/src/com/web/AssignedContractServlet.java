package com.web;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.model.*;
import com.service.*;
import com.utils.*;


public class AssignedContractServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		//let the user login if it not login
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{	
			try
			{
				ContractService contractService = new ContractService();
				List<ConBusiModel> contractList = new ArrayList<ConBusiModel>();
				//get the assigned contract of the user
				contractList = contractService.getAssignedContract(userId);
				//send the contract list to jsp
				request.setAttribute("contractList", contractList);
				request.getRequestDispatcher("/AssignedContract.jsp").forward(request, response);
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
