package com.web;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ToAddUserServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//turn to page 'adduser'
		request.getRequestDispatcher("/AddUser.jsp")
				.forward(request, response);
	}
}
