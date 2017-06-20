package com.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ToDraftServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/DraftContract.jsp")
				.forward(request, response);
	}
}
