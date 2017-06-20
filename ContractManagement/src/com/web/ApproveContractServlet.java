package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;


public class ApproveContractServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		//let the user login if not login
		if (userId == null)
		{
			response.sendRedirect("toLogin");
		}
		else
		{

			//get contract id and content and operation
			String conId = request.getParameter("conId");
			String content = request.getParameter("content");
			String approve = request.getParameter("approve");

			//create a contract process
			ConProcess conProcess = new ConProcess();
			conProcess.setConId(Integer.parseInt(conId));
			conProcess.setUserId(userId);
			conProcess.setContent(content);
			
			//if the user pass the contract
			if (approve.equals("true")) {
				conProcess.setState(Constant.DONE);
			}
			//if the user refuse the contract
			else 
			{
				conProcess.setState(Constant.VETOED);
			}

			try 
			{
				ContractService contractService = new ContractService();
				contractService.approve(conProcess);
				//show the approve contract list to the jsp
				response.sendRedirect("approveContractList");
			} catch (AppException e)
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
