package com.web;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class ApproveContractListServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer myId = (Integer)session.getAttribute("userId");
		
		// let the user login
		if (myId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			
			try {
				ContractService contractService = new ContractService();
				List<ConBusiModel> contractList = new ArrayList<ConBusiModel>();
				//get the contract to be approved
				contractList = contractService.getApproveList(myId);
				//send the approve list to the jsp
				request.setAttribute("contractList", contractList);
				request.getRequestDispatcher("/ApproveContractList.jsp").forward(request, response);
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
