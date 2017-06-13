package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.CustomerDaoImpl;
import com.model.ConDetailBusiModel;
import com.model.Customer;
import com.service.ContractService;
import com.utils.AppException;

/**
 * Servlet for checking contract details 
 */
public class CustomerDetail extends HttpServlet {

	/**
	 * Jump to contract details page
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set the request's character encoding
		request.setCharacterEncoding("UTF-8");
		
		// Declare session
		HttpSession session = null;
		// Get session by using request
		session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// If user is not login, jump to login page
		if (userId == null) {
			response.sendRedirect("toLogin");
		} else {

			// Get contract id
			int conId = Integer.parseInt(request.getParameter("conId"));

			try {
				// Initialize contractService
				CustomerDaoImpl customerdao=new CustomerDaoImpl();
				Customer customer= customerdao.getById(Integer.parseInt(request.getParameter("conId")));
				// Save contract to request
				request.setAttribute("customer", customer);
				// Forward to countersign page
				request.getRequestDispatcher("/CustomerDetail.jsp").forward(
						request, response);
			} catch (AppException e) {
				e.printStackTrace();
				// Redirect to the exception page
				response.sendRedirect("toError");
			}
		}
	}

	/**
	 * Process GET requests
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Call doPost() to process request
		this.doPost(request, response);
	}
}
