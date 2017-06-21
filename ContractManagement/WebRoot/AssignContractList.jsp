<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.model.ConBusiModel"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>List of contract to be assigned</title>
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
		<!-- Use JavaScript script to open a new window display information when preview-->
		<script>
			function preview(url) {
				window.open(url,'Preview','toolbar=no,scrollbars=yes,width=720,height=560');
			}
		</script>
	</head>

	<body>
		<div class="mtitle">
			Contracts to be assigned
		</div>
		
		
		<div class="list">
		  <table>
			<tr>
				<th>
					Contract name
				</th>
				<th class="th1">
					Draft time
				</th>
				<th class="th1">
					Operation
				</th>
			</tr>
			<%
				List<ConBusiModel> contractList = (List<ConBusiModel>)request.getAttribute("contractList");  
		        for (ConBusiModel cbm : contractList) {
       	 	%>
			<tr>
				<td class="tdname">
					<a href="javascript:void(0)"><%=cbm.getConName()%></a>
				</td>
				<td>
					<%=cbm.getDrafTime()%>
				</td>
				<td>
					<a href="toAssignContract?conId=<%=cbm.getConId()%>">
						<img src="images/cog_edit.png"  alt="Assign" />
						Assign
					</a>
				</td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="3"> </td>
			</tr>
		   </table>
		</div>

		
	</body>
</html>
