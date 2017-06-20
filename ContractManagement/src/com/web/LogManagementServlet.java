package com.web;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.impl.LogManagementDaoImpl;
import com.model.*;
import com.service.*;
import com.utils.*;

public class LogManagementServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer) session.getAttribute("userId");

		//let user login if not
		if (userId == null) {
			response.sendRedirect("toLogin");
		}
		else 
		{
			int choose = Integer.parseInt(request.getParameter("open").toString());
			LogManagementDaoImpl op = new LogManagementDaoImpl();
			try {
				//user choose open log
				if(choose==1)
				{
					op.openLog();
					op.setChoose("1");
				}
				//user choose close log
				if(choose == 0)
				{
					op.closeLog();
					op.setChoose("0");
				}
				// After configuration,redirect to Log Management page
				response.sendRedirect("toLogManagement");
			} catch (AppException e) {
				e.printStackTrace();
				// Redirect to the exception page
				response.sendRedirect("toError");
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
