package com.web;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class DraftContractServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		 
		//let user login if not
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}else {
			// get contract information
			String name = request.getParameter("name");
			String customer = request.getParameter("customer");
			String content = request.getParameter("content");
			String beginTime = request.getParameter("beginTime");
			String endTime = request.getParameter("endTime");
			String message = "";
			Date begin = new Date();
			Date end = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			
			try 
			{
				begin = dateFormat.parse(beginTime);
				end = dateFormat.parse(endTime);
				
				//set contract information
				Contract contract = new Contract();
				contract.setName(name);
				contract.setCustomer(customer);
				contract.setBeginTime(begin);
				contract.setEndTime(end);
				contract.setContent(content);
				contract.setUserId(userId);
				
				ContractService contractService = new ContractService();
				//try to create the contract
				if (contractService.draft(contract))
				{
					message = "Drafting succeeded!";
					//send the contract to jsp
					request.setAttribute("contract", contract);
				} 
				else
				{
					message = "Drafting failure!";
				}
			} catch (ParseException e) 
			{
				e.printStackTrace();
				message = "Contract data is required. Incorrect date format";
			}
			catch (AppException e) 
			{
				e.printStackTrace();
			}
			//send message to jsp
			request.setAttribute("message", message);
			//turn to jsp 
			request.getRequestDispatcher("/DraftContract.jsp").forward(request, response);
		}
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

}
