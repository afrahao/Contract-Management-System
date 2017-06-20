package com.web;

import java.io.IOException;
<<<<<<< HEAD
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> origin/LiWenjie

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

<<<<<<< HEAD
import com.model.ConBusiModel;
import com.model.Contract;
import com.model.Role;
import com.service.ContractService;
=======
import com.model.Role;
>>>>>>> origin/LiWenjie
import com.service.UserService;
import com.utils.AppException;

/**
 * Login Servlet
 */
public class LoginServlet extends HttpServlet {

	/**
	 *  Process the POST login request
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set request's character encoding
		request.setCharacterEncoding("UTF-8");
		//  Get login information
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		// Initialize userId
		int userId = -1;
		// Initialize prompt message
		String message = "";
		/*
		 *  Call methods in business logic layer to process business logic 
		 */
		try {
			// Initialize the user business logic class
			UserService userService = new UserService();
			// Call business logic layer for user login
			userId = userService.login(name, password);
			if (userId > 0) { // login successfully  
				//  Declare session
				HttpSession session = null;
				// Get session by using request
				session = request.getSession();
				// Save userId and user name into session
				session.setAttribute("userId", userId);
				session.setAttribute("userName", name);
				// Declare role
				Role role = null;
				//Call business logic layer to get role's information
				role = userService.getUserRole(userId);
				
<<<<<<< HEAD
				// Initialize contractService
				ContractService contractService = new ContractService();
				// Initialize contractList
				List<ConBusiModel> contractList = new ArrayList<ConBusiModel>();
				Contract contractCoun = new Contract();
				Contract contractFina = new Contract();
				Contract contractAppr = new Contract();
				Contract contractSign = new Contract();
				
				// Call business logic layer to get list of contract to be countersigned 
				contractList = contractService.getDhqhtList(userId);
				contractCoun = contractService.FindLatest(contractList);
				
				contractList = contractService.getDdghtList(userId);
				contractFina = contractService.FindLatest(contractList);
				
				contractList = contractService.getDshphtList(userId);
				contractAppr = contractService.FindLatest(contractList);
				
				contractList = contractService.getDqdhtList(userId);
				contractSign = contractService.FindLatest(contractList);
				
				String tip1="",tip2="",tip3 = "",tip4 = "";
				if(contractCoun != null)
				{
					tip1="You have a contract that must be countersigned soon:"+contractCoun.getName()+"\n";
				}
				if(contractFina != null)
				{
					tip2="You have a contract that must be finalized soon:"+contractFina.getName()+"\n";
					
				}
				if(contractAppr != null)
				{
					tip3="You have a contract that must be approved soon:"+contractAppr.getName()+"\n";
				}
				if(contractSign != null)
				{
					tip4="You have a contract that must be signed soon:"+contractSign.getName()+"\n";
				}
				
=======
>>>>>>> origin/LiWenjie
				// Process page jump according to the user's role
				if ( role == null) {
					//Redirect to new user page
					response.sendRedirect("toNewUser");
				} else if (role.getName().equals("admin")) {
					//Redirect to administrator page
					response.sendRedirect("adminFrame");
				} else if (role.getName().equals("operator")) {
					//Redirect to operator page 
					response.sendRedirect("operatorFrame");
				}
<<<<<<< HEAD
				if(contractFina !=null || contractAppr!=null ||contractSign!=null ||contractCoun!=null)
				{
					JOptionPane.showMessageDialog(null, tip1+tip2+tip3+tip4, "tip", JOptionPane.INFORMATION_MESSAGE);
				}
=======
>>>>>>> origin/LiWenjie
			} else {// Login failed
				// Set prompt message
				message = "Incorrect user name or password!";
				request.setAttribute("message", message); // Save prompt message into request
				// Save user name into request
				request.setAttribute("userName", name);	
				// Forward to login page
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			}
		} catch (AppException e) {
			e.printStackTrace();
			// Redirect to exception page
			response.sendRedirect("toError");
<<<<<<< HEAD
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
=======
>>>>>>> origin/LiWenjie
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
