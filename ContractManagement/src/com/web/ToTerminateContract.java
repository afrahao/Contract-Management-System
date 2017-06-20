package com.web;

import java.util.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.impl.ContractDaoImpl;
import com.model.*;
import com.utils.*;
public class ToTerminateContract extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// If user is not login, jump to login page
		if (userId == null) {
			response.sendRedirect("toLogin");
		}else {
			
			
			try {
				ContractDaoImpl contractdao=new ContractDaoImpl();
				List<Contract> contractList=contractdao.getFinalized();
				request.setAttribute("contractList", contractList);
			} catch (AppException e) {
				e.printStackTrace();
			}
			// Forward to terminate page
			request.getRequestDispatcher("/ToTerminateContract.jsp").forward(
					request, response);
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
