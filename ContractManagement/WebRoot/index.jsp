<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Contract Management System - Welcome</title>
		<link href="css/frame.css" rel="stylesheet" 
			type="text/css" />
	</head>
	<body>
		<div class="content">
			<p>
			Welcome to Contract Management System!
			<br />			
			Current time:
			<SCRIPT language = JavaScript>
				var mydate = new Date();
				var month = mydate.getMonth()+1;
				document.write(mydate.getYear()+"-"+month +"-"+mydate.getDate()+"     "+mydate.getHours()+":"+mydate.getMinutes());		
			</SCRIPT>
			</p>
			<a href="toLogin">Login</a>|<a href="register">Register</a>
		</div>
	</body>
</html>
