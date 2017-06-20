package com.web;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class ApprovedContractServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		//if the user not login, he or she is so silly= =
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
				//get the approved contract list
				contractList = contractService.getApprovedContract(userId);
				//send the contract list to jsp
				request.setAttribute("contractList", contractList);
				request.getRequestDispatcher("/ApprovedContract.jsp").forward(request, response);
			}
			catch (AppException e) 
			{
				e.printStackTrace();
				//our conding can't have error!so this page will not be showed!
				response.sendRedirect("toError");
			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		this.doPost(request, response);
	}
}
