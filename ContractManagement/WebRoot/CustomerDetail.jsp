<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.model.Customer"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Customer Detail</title>
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
	</head>

	<body>
		<div class="mtitle">
			Customer Detail
		</div>	
		<br />
		<%Customer customer=(Customer) request.getAttribute("customer"); %>
		<table class="update" style="width:500px;">
				<tr height="28">
				
					<td width="140px">Customer name:</td>
					<td>
						<%=customer.getName() %>
					</td>	
				</tr>
				<tr height="28">
					<td>Phone number:</td>
					<td><%=customer.getTel() %></td>
				</tr>
				<tr height="28">
					<td>Address:</td>
					<td><%=customer.getAddress() %></td>
				</tr>
				<tr height="28">
					<td>Fax:</td>
					<td><%=customer.getFax() %></td>
				</tr>
				<tr height="28">
					<td>Code:</td>
					<td><%=customer.getCode() %></td>
				</tr>
				<tr height="28">
					<td>Bank name:</td>
					<td><%=customer.getBank() %> </td>
				</tr>
				<tr height="28">
					<td>Bank account:</td>
					<td><%=customer.getAccout() %> </td>
				</tr>
				<tr>
					<td>Num:</td>
					<td>
						<%=customer.getNum() %>
					</td>
				</tr>
				
			</table>
	</body>
</html>
