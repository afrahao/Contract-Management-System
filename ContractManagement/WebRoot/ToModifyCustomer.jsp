<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.model.Customer"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Edit Customer</title>
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
	</head>

	<body>
		<div class="mtitle">
			Edit Customer
		</div>	
		
		<form action="modifyCustomer" method="post">
		
			<table class="update" style="width:700px;">
				<tr height="28">
				<%Customer customer=(Customer)request.getAttribute("customer"); %>
					<td width="140px">Customer name:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr height="28">
					<td>Phone number:</td>
					<td><input type="text" name="tel"/></td>
				</tr>
				<tr height="28">
					<td>Address:</td>
					<td><input type="text" name="address"/></td>
				</tr>
				<tr height="28">
					<td>Fax:</td>
					<td><input type="text" name="fax" /></td>
				</tr>
				<tr height="28">
					<td>Code:</td>
					<td><input type="text" name="code" /></td>
				</tr>
				<tr height="28">
					<td>Bank name:</td>
					<td><input type="text" name="bank" /></td>
				</tr>
				<tr height="28">
					<td>Bank account:</td>
					<td><input type="text" name="count" /></td>
				</tr>
				<tr height="28">
					<td>Num:</td>
					<td><input type="text" name="num" /></td>
				</tr>
				
				<tr height="28">
					<td align="center" colspan="2">
						<input type="submit" value="Submit" class="button"> &nbsp; &nbsp; &nbsp;
						<input type="reset" value="Reset" class="button">
					</td>
				</tr>
			</table><input type="hidden" id="conId" name="conId" value="<%=customer.getId()%>">
		</form>
	</body>
</html>
