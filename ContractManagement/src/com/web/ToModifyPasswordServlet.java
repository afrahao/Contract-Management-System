package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
public class ToModifyPasswordServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		// let user login if not
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		} else {

			// Get user name and id
			String name = request.getParameter("userName");
			String Id = request.getParameter("userId");
			User user = new User();
			user.setName(name);
			user.setId(Integer.parseInt(Id.toString()));
			user.setDel(0);
			request.setAttribute("user", user);
			// turn to modify password page
			request.getRequestDispatcher("/ModifyPassword.jsp").forward(
					request, response);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
