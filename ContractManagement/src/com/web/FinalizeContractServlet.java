package com.web;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class FinalizeContractServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer) session.getAttribute("userId");

		//let user login if not
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			// get contract information
			int conId = Integer.parseInt(request.getParameter("conId"));
			String name = request.getParameter("name");
			String customer = request.getParameter("customer");
			String beginTime = request.getParameter("beginTime");
			String endTime = request.getParameter("endTime");
			String content = request.getParameter("content");
			
			Date begin = new Date();
			Date end = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			try
			{
				//set contract information
				begin = dateFormat.parse(beginTime);
				end = dateFormat.parse(endTime);
				Contract contract = new Contract();
				contract.setId(conId);
				contract.setName(name);
				contract.setCustomer(customer);
				contract.setBeginTime(begin);
				contract.setEndTime(end);
				contract.setContent(content);
				contract.setUserId(userId);

				ContractService contractService = new ContractService();
				//try to finalize contract
				contractService.finalize(contract);
				//turnto jsp
				response.sendRedirect("finalizeContractList");
			}
			catch (ParseException e) 
			{
				e.printStackTrace();
				String message = "";
				message = "Please enter the correct date format!";
				//send message to jsp
				request.setAttribute("message", message);
				//turn to jsp
				request.getRequestDispatcher("/FinalizeContract.jsp").forward(request, response);
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
