package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class ToApproveContractServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		// let user login if it not login
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{

			// get contract id
			int conId = Integer.parseInt(request.getParameter("conId"));

			try {
				ContractService contractService = new ContractService();
				Contract contract = contractService.getContract(conId);

				// send approve contract list
				request.setAttribute("contract", contract);
				// turn to approval page
				request.getRequestDispatcher("/ApproveContract.jsp").forward(
						request, response);
			}
			catch (AppException e)
			{
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
