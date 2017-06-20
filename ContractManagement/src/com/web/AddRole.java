package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.dao.impl.*;
import com.model.*;

public class AddRole extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		//let the user login if he or she not login
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else 
		{
			String[] privlege=request.getParameterValues("check");
			String function;
			RoleDaoImpl roledao=new RoleDaoImpl();
			Role role=new Role();
			//set the role information
			role.setName(request.getParameter("name"));
			role.setDescription(request.getParameter("content"));
			role.setDel(0);
			function=privlege[0];
			//set the privilege
			for(int i=1;i<privlege.length;i++)
			{
				function=function+","+privlege[i];
			}
			role.setFuncIds(function);
			roledao.addRole(role);
			response.sendRedirect("roleList");
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

}
