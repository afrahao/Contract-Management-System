package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;


public class AssignContractServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		//let the user login if he or she not login
		if (userId == null)
		{
			response.sendRedirect("toLogin");
		}
		
		//the contract id
		int conId = Integer.parseInt(request.getParameter("conId"));
		//user id that coungtersign this contract
		String[] hqht = request.getParameterValues("hqht");
		//user id that approve this contract
		String[] spht = request.getParameterValues("spht");
		//user id that sign this contract
		String[] qdht = request.getParameterValues("qdht");
		
		ConProcess conProcess = new ConProcess();
		conProcess.setConId(conId);
		conProcess.setUserId(userId);
		conProcess.setContent(null);

		conProcess.setState(Constant.DONE);

		try 
		{
			ContractService contractService = new ContractService();
			
			//countersigner
			for (String hq : hqht)
			{
				contractService.distribute(conId, Integer.parseInt(hq),Constant.PROCESS_CSIGN);
			}
			//approver
			for (String sp : spht)
			{
				contractService.distribute(conId, Integer.parseInt(sp), Constant.PROCESS_APPROVE);
			}
			//signer
			for (String qd : qdht)
			{
				contractService.distribute(conId, Integer.parseInt(qd), Constant.PROCESS_SIGN);
			}
		
			contractService.distribute(conId, Integer.parseInt(userId.toString()), Constant.PROCESS_ASSIGN);
			contractService.assign(conProcess);
			response.sendRedirect("assignContractList");
		} catch (AppException e)
		{
			e.printStackTrace();
			response.sendRedirect("toError");
		}
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

}
