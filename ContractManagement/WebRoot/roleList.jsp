<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.model.Role"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Role list</title>
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
	</head>

	<body>
		<div class="mtitle">
			Role list
		</div>
		<br />

		<div style="text-align:right;width:480px;">
		   <a href=AddRole.jsp>
				<img src="images/add.png"  alt="Add Role" />
				Add Role
			</a>
		</div>

		<div class="list">
		  <table>
			<tr>
				<th style="width:100px;">
					Role name
				</th>
				<th>
					Description
				</th>
				<th style="width:100px;">
					 del
				</th>
				<th>
					Operation
				</th>
			</tr>
			<%
					List<Role> roleList = (List<Role>) request
							.getAttribute("roleList");
					for (Role role : roleList) {
				%>
			<tr>
				<td class="tdname">
					<%=role.getName() %>
				</td>
				<td class="tdname">
					<%=role.getDescription() %>
				</td>
				<td>
					<%=role.getDel() %>
				</td>
				<td>
					<a href="EditRole?roleId=<%=role.getId()%>">
						<img src="images/icon-edit.png"  alt="Edit" />
						Edit
					</a>
				</td>
			</tr>
			<%
				}
			 %>
			
			<tr>
				<td colspan="5"> </td>
			</tr>
		  </table>
		</div>
	</body>
</html>
