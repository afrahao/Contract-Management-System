<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.model.ConState"%>
<%@page import="com.dao.impl.ContractDaoImpl"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
		
		
	</head>

	<body>
		<div class="mtitle">
			Contract Process
		</div>
		
		<div class="search">
			<form>
				Search contract state
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
					Time
				</th>
				<th class="th1">
					State
				</th>
				<th width="270px">
					del
				</th>
			</tr>
			
			<tr>
				
			</tr>
			<%
				List<ConState> constate=(List<ConState>) request.getAttribute("constate");
				ContractDaoImpl cont=new ContractDaoImpl();
				for (ConState state : constate) {
			 %>
			
			<tr>
				<td class="tdname">
					<%=cont.getById(state.getConId()).getName() %>
				</td>
				<td class="tdname">
					<%=state.getTime() %>
				</td>
				<td>
					<%=state.getState(state.getType()) %>
				</td>
				<td>
					<%=state.getDel() %>
				</td>
			</tr>
			<%
				}
				%>
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
