package com.web;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.impl.ConStateDaoImpl;
import com.model.*;
import com.utils.*;
public class ToQProcess extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		// If user is not login, jump to login page
		if (userId == null) {
			response.sendRedirect("toLogin");
		}else {
			
			try {
				ConStateDaoImpl statedao=new ConStateDaoImpl();
				List<ConState> constate=null;
				constate=statedao.getAll();
				request.setAttribute("constate", constate);
			}
			catch (AppException e) 
			{
				e.printStackTrace();
			}
			// Forward to QProcess page
			request.getRequestDispatcher("/QProcess.jsp").forward(
					request, response);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
