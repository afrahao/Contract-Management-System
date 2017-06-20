package com.web;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class SignedContractServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		//let user login if not login
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
				//get signed contract
				contractList = contractService.getSignedContract(userId);
				//send signed contract list to jsp
				request.setAttribute("contractList", contractList);
				// turn to jsp
				request.getRequestDispatcher("/SignedContract.jsp").forward(request, response);
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
