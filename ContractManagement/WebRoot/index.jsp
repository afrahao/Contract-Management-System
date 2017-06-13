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
	
	<frameset rows="100,*" frameborder="no" border="0">
		<frame src="LogHeader.jsp"  scrolling="no"/>
		<frame src="welcome.jsp"  scrolling="no"/>
	</frameset>
	
	<noframes>
		<body>
			Your browser does not support frame structure!
		</body>
	</noframes>
	
</html>
