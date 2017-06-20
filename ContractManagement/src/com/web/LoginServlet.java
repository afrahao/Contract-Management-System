package com.web;


import com.model.*;
import com.service.*;
import com.utils.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.swing.*;

//Login
public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int myId = -2;
		request.setCharacterEncoding("UTF-8");
		//get name and pass word
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String message = "";
		try {
			UserService userService = new UserService();
			//try to login using the function in the login layer
			myId = userService.login(name, password);
			//if login successfully
			if (myId > 0) {
				HttpSession session = null;
				session = request.getSession();
				//get the user's id and name from the jsp
				session.setAttribute("userId", myId);
				session.setAttribute("userName", name);
				Role myRole = null;
				//get the user's myRole
				myRole = userService.getUserRole(myId);
				ContractService contractService = new ContractService();
				
				List<ConBusiModel> contractList = new ArrayList<ConBusiModel>();
				//get different contracts of the user
				Contract contractCoun = new Contract();
				Contract contractFina = new Contract();
				Contract contractAppr = new Contract();
				Contract contractSign = new Contract();
				
				//get the user's contracts
				contractList = contractService.getCountersignList(myId);
				contractCoun = contractService.FindLatest(contractList);
				
				contractList = contractService.getFinalizeList(myId);
				contractFina = contractService.FindLatest(contractList);
				
				contractList = contractService.getApproveList(myId);
				contractAppr = contractService.FindLatest(contractList);
				
				contractList = contractService.getSignList(myId);
				contractSign = contractService.FindLatest(contractList);
				
				//tip messages
				String tip1="",tip2="",tip3 = "",tip4 = "";
				//set the tip messages
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
				//remind the user
				if(contractFina !=null || contractAppr!=null ||contractSign!=null ||contractCoun!=null)
				{
					JOptionPane.showMessageDialog(null, tip1+tip2+tip3+tip4, "tip", JOptionPane.INFORMATION_MESSAGE);
				}
				//if the user has no privilege
				if ( myRole == null)
				{
					response.sendRedirect("toNewUser");
				}
				//if the user is the administrator
				else if (myRole.getName().equals("admin"))
				{
					response.sendRedirect("adminFrame");
				}
				//if the user is not the administrator
				else if (myRole.getName().equals("operator")) 
				{
					response.sendRedirect("operatorFrame");
				}
			// Login failed
			} else {
				message = "Incorrect user name or password!";
				//send the message
				request.setAttribute("message", message);
				request.setAttribute("userName", name);	
				//let the user login again
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			}
		} catch (AppException e) 
		{
			e.printStackTrace();
			response.sendRedirect("toError");
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		this.doPost(request, response);
	}
}
