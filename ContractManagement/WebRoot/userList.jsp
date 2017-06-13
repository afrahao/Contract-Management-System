<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>User list</title>
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
		<!-- Use JavaScript script to open a new window display information when preview-->
		<script>
			function preview(url) {
				window.open(url,'Preview','toolbar=no,scrollbars=yes,width=720,height=560,top=50,left=100');
			}
		</script>
	</head>

	<body>
		<div class="mtitle">
			User list
		</div>

		<div class="search">
		  <div style="float:left;width:600px;">
			<form>
				Search User:
				<input value="Enter the search conditions.." />
				&nbsp;&nbsp;
				<input type="submit" value="Search" class="search-submit"/> <br />
			</form>		
		  </div>

		  <div style="float:left;width:150px;">
			<a href="addCustomer.htm">
				<img src="images/add.png"  alt="Add Customer" />
				Add User
			</a>
          </div>
		</div>
		<br />
		<div class="list">
		  <table>
			<tr>
				<th>
					User name
				</th>
				<th>
					password
				</th>
				<th>
					del
				</th>
				
				<th style="width:150px;text-align:center;">
					Operation
				</th>
			</tr>
			<tr>
				<td class="tdname">
					
				</td>
				<td>
					
				</td>
				<td>
					
				</td>
				
				
				<td>
					<a href="editCustomer.htm">
						<img src="images/icon-edit.png"  alt="Edit" />
						Edit
					</a>
					| 
					<a href="">
						<img src="images/delete.png"  alt="Delete" />
						Delete
					</a>
				</td>
			</tr>
			
			<tr>
				<td class="tdname">
					<a href="javascript:preview('customerDetail.htm');">fasker</a>
				</td>
				<td>
					Shanghai
				</td>
				<td>
					11111111111
				</td>
				
				
				<td>
					<a href="editCustomer.htm">
						<img src="images/icon-edit.png"  alt="Edit" />
						Edit
					</a>
					| 
					<a href="">
						<img src="images/delete.png"  alt="Delete" />
						Delete
					</a>
				</td>
			</tr>
			<tr>
				<td class="tdname">
					<a href="javascript:preview('customerDetail.htm');">biferny</a>
				</td>
				<td>
					Beijing
				</td>
				<td>
					11111111111
				</td>
				
				<td>
					<a href="editCustomer.htm">
						<img src="images/icon-edit.png"  alt="Edit" />
						Edit
					</a>
					| 
					<a href="">
						<img src="images/delete.png"  alt="Delete" />
						Delete
					</a>
				</td>
			</tr>
			<tr>
				<td class="tdname">
					<a href="javascript:preview('customerDetail.htm');">jaffson</a>
				</td>
				<td>
					HuBei WuHan
				</td>
				<td>
					11111111111
				</td>
				
				<td>
					<a href="editCustomer.htm">
						<img src="images/icon-edit.png"  alt="Edit" />
						Edit
					</a>
					| 
					<a href="">
						<img src="images/delete.png"  alt="Delete" />
						Delete
					</a>
				</td>
			</tr>
			<tr>
				<td colspan="7"> </td>
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
