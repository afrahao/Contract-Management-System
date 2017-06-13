<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.model.ConBusiModel"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
		<title>User Management</title>
		<!-- Use JavaScript script to open a new window display information when preview-->
		<script>
			function preview(url) {
				window.open(url,'Preview','toolbar=no,scrollbars=yes,width=720,height=560');
			}
		</script>
	</head>

	<body>
		<div class="mtitle">
			User Management
		</div>
		
		<div class="list">
			<jsp:include page="UserLeft.jsp"></jsp:include>		  
		</div>

		<div align="right" class="pagelist">					
			<a href="#"><img src="images/page/first.png"  alt="" /></a> &nbsp;
			<a href="#"><img src="images/page/pre.png"  alt="" /></a>&nbsp;
			<a href="#"><img src="images/page/next.png"  alt="" /></a>&nbsp;
			<a href="#"><img src="images/page/last.png"  alt="" /></a>&nbsp;
					
			<span class="pageinfo">
				Total&nbsp;<strong>2</strong>&nbsp;pages&nbsp;<strong>13</strong>&nbsp;records
			</span>	
		</div>
	</body>
</html>
