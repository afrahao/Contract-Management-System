package com.web;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;
import com.service.*;
import com.utils.*;


public class AssignContractListServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{	
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		//everyone need to login
		if (userId == null)
		{
			response.sendRedirect("toLogin");
		}
		else
		{
			try {
				UserService userService = new UserService();
				Role role = userService.getUserRole(userId);
				
				//if the user has no privilege
				if ( role == null) 
				{
					response.sendRedirect("toNewUser");
				}
				else
				{
					//get functions the user can process
					String funcIds = role.getFuncIds();	
					boolean countersign = false,approve = false,sign = false;
					
					for (String id : funcIds.split(",")) {
						// assign countersign
						if (id.equals("008"))
						{
							countersign = true;
						}
						//assign approval
						if (id.equals("009"))
						{
							approve = true;
						}
						//assign sign
						if (id.equals("010"))
						{
							sign = true;
						}
					}
					
					//the user can assign all the privilege
					if (countersign && approve && sign) {
						ContractService contractService = new ContractService();
						List<ConBusiModel> contractList = new ArrayList<ConBusiModel>();
						contractList = contractService.getAssignList();
						//send the assign contract list to jsp
						request.setAttribute("contractList", contractList);
						request.getRequestDispatcher("/AssignContractList.jsp").forward(request, response);
					}
					else
					{	
						PrintWriter out = response.getWriter();
						out.println("<script language = javascript>alert('You don't have the permission!')");
						response.sendRedirect("toNewUser");
					}
				}
			}
			catch (AppException e) 
			{
				e.printStackTrace();
				response.sendRedirect("toError");
			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

}
