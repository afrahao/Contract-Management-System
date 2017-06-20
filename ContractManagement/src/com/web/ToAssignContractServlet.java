package com.web;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.model.*;
import com.service.*;
import com.utils.*;

public class ToAssignContractServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		session = request.getSession();
		//get user id
		Integer userId = (Integer)session.getAttribute("userId");
		
		//let user login if it didn't
		if (userId == null) 
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			// Get contract id
			int conId = Integer.parseInt(request.getParameter("conId"));
			
			try 
			{
				ContractService contractService = new ContractService();
				Contract contract = contractService.getContract(conId);
				UserService userService = new UserService();
			
				//operator role id
				int roleId = 2;
				//administrator role id
				int RoleId = 1;

				List<User> userList = new ArrayList<User>();
				List<User> userList1 = new ArrayList<User>();
				// Get user list according to role id
				userList = userService.getUserListByRoleId(roleId);
				userList1 = userService.getUserListByRoleId(RoleId);
			
				userList.addAll(userList1);
			
				//send contract to jsp
				request.setAttribute("contract", contract);
				///send user list to jsp
				request.setAttribute("userList", userList);
				//turn to page assigncontract
				request.getRequestDispatcher("/AssignContract.jsp").forward(request,response);
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
