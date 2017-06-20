package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class CountersignOpinionServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		//let user login if not
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		} else {
			
			//get contract id and content
			int conId = Integer.parseInt(request.getParameter("conId"));
			String content = request.getParameter("content");
			
			//create a process
			ConProcess conProcess = new ConProcess();
			conProcess.setConId(conId);
			conProcess.setUserId(userId);
			conProcess.setContent(content);
			
			try {
				ContractService contractService = new ContractService();
				//countersign contract
				contractService.counterSign(conProcess);
				//turn to jsp
				response.sendRedirect("countersignContractList");

			} catch (AppException e) {
				e.printStackTrace();
				response.sendRedirect("toError");
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
