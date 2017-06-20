package com.web;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.impl.RoleDaoImpl;
import com.model.*;
import com.service.*;
import com.utils.*;

public class Submitrole extends HttpServlet{

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
			
			// get right of the role
			String[] privlege=request.getParameterValues("check");
			String function;
			String[] cont=request.getParameterValues("content");
			String content="";
			function=privlege[0];
			//set the right of the role
			for(int i=1;i<privlege.length;i++)
			{
				function=function+","+privlege[i];
			}
			for(int i=0;i<cont.length;i++)
			{
				content=content+cont[i];
			}
			RoleDaoImpl roledao=new RoleDaoImpl();
			//get role is
			int roleId =Integer.parseInt(request.getParameter("roleId"));
			//modify the role's right
			roledao.modifyDes(content,roleId);
			roledao.modifyFun(function, roleId);
			response.sendRedirect("roleList");
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
