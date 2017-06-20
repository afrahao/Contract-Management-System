package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class SignServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer) session.getAttribute("userId");

		//let user login if not login
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{

			// Get contract id and sign sontent
			int conId = Integer.parseInt(request.getParameter("conId"));
			String content = request.getParameter("content");

			// create a new process
			ConProcess conProcess = new ConProcess();
			conProcess.setConId(conId);
			conProcess.setUserId(userId);
			conProcess.setContent(content);

			try {
				ContractService contractService = new ContractService();
				contractService.sign(conProcess);

				//send sign contract list
				response.sendRedirect("signContractList");
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
