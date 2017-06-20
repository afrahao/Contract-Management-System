package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.impl.RoleDaoImpl;
import com.model.*;
import com.service.*;
import com.utils.*;

public class EditRole extends HttpServlet{

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
		}
		else
		{
			
			try {
				UserService userService = new UserService();
				RoleDaoImpl roledao=new RoleDaoImpl();
				int roleId = Integer.parseInt(request.getParameter("roleId"));
				//get role
				Role role=roledao.getById(roleId);
				request.setAttribute("role", role);
				//turn to jsp
				request.getRequestDispatcher("/EditRole.jsp").forward(request, response);
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

