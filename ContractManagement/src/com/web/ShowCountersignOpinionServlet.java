package com.web;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;

public class ShowCountersignOpinionServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		// Get session by using request
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		//let the user login if not
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			//  get contract id
			int conId = Integer.parseInt(request.getParameter("conId"));
			
			try 
			{
				ContractService contractService = new ContractService();
				List<CSignatureOpinion> csOpinionList = new ArrayList<CSignatureOpinion>();
				//countersign opinion
				csOpinionList = contractService.showCountersignOpinion(conId);
				//send contract list to jsp
				request.setAttribute("csOpinionList", csOpinionList);
				//turn to jsp
				request.getRequestDispatcher("/ShowCountersignOpinion.jsp").forward(request,response);
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
