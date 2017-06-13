<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.model.User"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
		<title>List of contract to be finalized</title>
		<!-- Use JavaScript script to open a new window display information when preview-->
		<script>
			function preview(url) {
				window.open(url,'Preview','resizable=no,toolbar=no,width=620,height=500,top=50,left=200');
			}
		</script>
	</head>

	<body>
		<div class="mtitle">
			Modify User
		</div>
		
		<div class="search">
			<form>
				Search user to be modified:
				<input value="Enter the search conditions.." />
				&nbsp;&nbsp;
				<input type="submit" value="Search" class="search-submit"/> <br />
			</form>
		</div>
		
		<div class="list">
		  <table>
			<tr>
				<th>
					User name
				</th>
				<th width="270px">
					Operation
				</th>
			</tr>
			<%
				List<User> userList = (List<User>)request.getAttribute("userList");  
		        for (User user : userList) {
       	 	%>
			<tr>
				<td class="tdname">
					<%=user.getName()%>
				</td>
				<td>
					<a href="toModifyPassword?userName=<%=user.getName()%>&userId=<%=user.getId()%>">
						<img src="images/icon-edit.png" />
						Modify   
					</a>
				</td>
			</tr>
			<%} %>
			
			<tr>
				<td colspan="3"> </td>
			</tr>
		  </table>
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
