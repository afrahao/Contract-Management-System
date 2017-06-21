<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page
	import="com.model.PermissionBusiModel,com.model.Role"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Log Management</title>
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
	</head>

	<body>
		<div class="mtitle">
			Log Management
		</div>
		<br />
		<form action="logManagement" method="post">
			<table class="update" style="width:500px;">
			<%
				String select = (String)request.getAttribute("select");
			%>
				<tr>
					<td>
						Database Log:
					</td>
					<td>
						<!-- Get user's role id that already had-->
						<input name="open" type="radio" value="1"
							<%if (select.equals("1")) {%> checked="checked" <%} %> />
						Open
						<br/>
						<br/>
						<input name="open" type="radio" value="0"
							<%if (select.equals("0")) {%> checked="checked" <%} %> />
						Close
					</td>
				</tr>
				<tr>
					<td>
						Operator Log:
					</td>
					<td>
						<a href="writeLog" target="main">Write log to file</a>
					</td>
				</tr>

				<tr height="28">
					<td align="center" colspan="2">
						<input type="submit" value="Submit" class="button">
						&nbsp; &nbsp; &nbsp;
						<input type="reset" value="Reset" class="button">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
