<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.model.PermissionBusiModel"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
		<title>User permission list</title>
	</head>

	<body>
		<div class="mtitle">
			User permission list
		</div>

		

		<div class="list">
			<table>
				<tr>
					<th>
						User name
					</th>
					<th class="th2">
						Role name
					</th>
					<th class="th2">
						Operation
					</th>
				</tr>
				<%
					List<PermissionBusiModel> permissionList = (List<PermissionBusiModel>) request
							.getAttribute("permissionList");
					for (PermissionBusiModel pbm : permissionList) {
				%>
				<tr>
					<td class="tdname">
						<%=pbm.getUserName()%>
					</td>
					<td>
						<%=pbm.getRoleName()%>
					</td>
					<td>
						<a
							href="toConfigurePermission?userId=<%=pbm.getUserId()%>&uName=<%=pbm.getUserName()%>&roleId=<%=pbm.getRoleId()%>">
							<img src="images/cog_edit.png" alt="Authorize" /> Authorize </a>
					</td>
				</tr>
				<%
					}
				%>
				<tr>
					<td colspan="3">
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
