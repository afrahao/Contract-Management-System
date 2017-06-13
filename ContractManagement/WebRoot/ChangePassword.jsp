<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Change Password</title>
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
		<script type="text/javascript">
			function check(){
				var name = document.getElementById('name');
				var password = document.getElementById('password');
				var password2 = document.getElementById('password2');
				if(name.value == ""){
					alert("User name can not be empty!");
					name.focus();
					return false;
				}
				if(password.value == ""){
					alert("Original password can not be empty!");
					password.focus();
					return false;
				}
				if(password2.value == ""){
					alert("New password can not be empty!");
					password.focus();
					return false;
				}			
			}
		</script>	
	</head>

	<body>

		<!-- main start -->
		<div class="main">
			<a href="toLogin">Comeback</a>
			<form action="changePassword" method="post">

				<div class="register_main">
					<table>
						<tr>
							<td class="title" colspan="2">
								Change Password
							</td>
						</tr>
						<tr>
							<td width="120" align="center">
								User Name:
							</td>
							<td>
								<input type="text" name="name" id="name" value="" />
							</td>
						</tr>
						<tr>
							<td class="info" colspan="2">
								Your user name.
							</td>
						</tr>

						<tr>
							<td align="center">
								Original Password:
							</td>
							<td>
								<input type="password" name="password" id="password" value="" />
							</td>
						</tr>
						<tr>
							<td class="info" colspan="2">
								Your original password.
							</td>
						</tr>

						<tr>
							<td align="center">
								New Password:
							</td>
							<td>
								<input type="password" name="password2" id="password2" value="" />
							</td>
						</tr>
						<tr>
							<td class="info" colspan="2">
								Your new password.
							</td>
						</tr>
						<tr>
							<td colspan="2" align="left" style="color:red;">
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
							<td colspan="2">
								<input type="submit" value="Submit" class="button" onclick="return check()"/>
							</td>
						</tr>
					</table>
				</div>

			</form>
		</div>
		<!-- main end -->


	</body>
</html>
