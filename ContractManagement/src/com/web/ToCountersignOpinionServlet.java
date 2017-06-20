package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class ToCountersignOpinionServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		//let user login if it didn't login
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else 
		{

			// Get contract id
			int conId = Integer.parseInt(request.getParameter("conId"));

			try {
				ContractService contractService = new ContractService();
				//get contract
				Contract contract = contractService.getContract(conId);
				// seng contract to jsp
				request.setAttribute("contract", contract);
				//  turn to page countersign
				request.getRequestDispatcher("/CountersignOpinion.jsp").forward(
						request, response);
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
