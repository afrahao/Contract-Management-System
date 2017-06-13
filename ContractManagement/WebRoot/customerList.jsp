<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.dao.impl.CustomerDaoImpl"%>
<%@page import="com.model.Customer"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Customter list</title>
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
			Customter list
		</div>

		<div class="search">
		  <div style="float:left;width:600px;">
			<form>
				Search Customer:
				<input value="Enter the search conditions.." />
				&nbsp;&nbsp;
				<input type="submit" value="Search" class="search-submit"/> <br />
			</form>		
		  </div>

		  <div style="float:left;width:150px;">
			<a href="toAddCustomer">
				<img src="images/add.png"  alt="Add Customer" />
				Add Customer
			</a>
          </div>
		</div>
		<br />
		<div class="list">
		  <table>
			<tr>
				<th>
					Customer name
				</th>
				<th>
					Address
				</th>
				<th>
					Phone Number
				</th>
				<th>
					Fax
				</th>
				<th>
					Code
				</th>
				<th style="width:150px;text-align:center;">
					Operation
				</th>
			</tr>
			<% 
				CustomerDaoImpl customerdao=new CustomerDaoImpl();
				List<Customer> customerList=(List<Customer>) customerdao.getAll();
				for (Customer customer : customerList) {
			%>
			<tr>
				<td class="tdname">
					<a href="javascript:preview('customerDetail?conId=<%=customer.getId()%>')"><%=customer.getName() %> </a>
				</td>
				<td>
					<%=customer.getAddress() %>
				</td>
				<td>
					<%=customer.getTel() %>
				</td>
				<td>
					<%=customer.getFax() %>
				</td>
				<td>
					<%=customer.getCode() %>
				</td>
				<td>
					<a href="toModifyCustomer?conId=<%=customer.getId()%>">
						<img src="images/icon-edit.png"  alt="Edit" />
						Edit
					</a>
					| 
					<a href="deleteCustomer?conId=<%=customer.getId()%>" >
						<img src="images/delete.png"  alt="Delete" />
						Delete
					</a>
				</td>
			</tr>
			<%
				}
			 %>
			
			
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
