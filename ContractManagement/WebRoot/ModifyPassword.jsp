<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.model.User"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Modify Password</title>
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
		<script type="text/javascript">
			function check()
			{
				var password = document.getElementById('password');
				if(password.value == ""){
					alert("Password can not be empty!");
					password.focus();
					return false;
				}
			}
		</script>
		
  	
	</head>

	<body>
		<!-- main start -->
		<div class="main">
			<form action="modifyPassword" method="post">
				<%
					User user = (User)request.getAttribute("user");
				%>
				<div class="register_main">
					<table>
						<tr>
							<td class="title" colspan="3">
								Modify Password
							</td>
						</tr>
						<tr>
							<td width="60">
								User name:
							</td>
							<!-- Get user name -->
							<td width="200">
								<input type="text" id="name" name="name" value="<%=user.getName()%>" readonly="readonly">
							</td>
							<td width="200"></td>
						</tr>

						<tr>
							<td>
								Password：
							</td>
							<td>
								<input type="password" name="password" id="password" value="" />
							</td>
							<td></td>
						</tr>
						<tr>
							<td colspan="3" align="left" style="color:red;">
							<%
								if (request.getAttribute("message") != null) {
							%>
							<%=request.getAttribute("message")%>
							<%
								}
							%>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<input type="submit" value="Modify" class="button" onclick="return check()" />
							</td>
							<td width="200">
								<input type="hidden" id="id" name="id" value="<%=user.getId()%>" readonly="readonly">
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<!-- main end -->

	</body>
</html>
