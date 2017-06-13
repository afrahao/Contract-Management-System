<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.model.Contract"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>List of finalized contract</title>
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
			Performing contract
		</div>
		
		<div class="search">
			<form>
				Search performing contract:
				<input value="Enter the search conditions.." />
				&nbsp;&nbsp;
				<input type="submit" value="Search" class="search-submit"/> <br />
			</form>
		</div>

		<div class="list">
		  <table>
						  
			 <tr>
				<th>
					Contract name
				</th>
				<th class="th1">
					End time
				</th>
				<th class="th1">
					Operate 
				</th>
			</tr>
			<% List<Contract> contractList=(List<Contract>)request.getAttribute("contractList"); 
				for(Contract contract:contractList){
			%>
			<tr>	
				<td class="tdname">
					<%=contract.getName() %>
				</td>
				<td>
					<%=contract.getEndTime() %>
				</td>
				<td>
					<a href="terminateContract?conId=<%=contract.getId()%>" >
						<img src="images/delete.png"  alt="Delete" />
						Delete
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
