<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Contract Management System - Administrator menu bar</title>
	<link href="css/frame.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
	<div class="menu">
		
		<dl>
			<dt>
				System Management
			</dt>
			<dd>
				<a href="userList.jsp" target="main">User Management</a>
			</dd>
			<dd>
				<a href="roleList" target="main">Role Management</a>
			</dd>		
			<dd>
				<a href="configurePermissionList" target="main">Configure Permission</a>
			</dd>
			<dd>
				<a href="#">Log Management</a>
			</dd>	
		</dl>
		<dl>
			<dt>
				Information Management
			</dt>
			
			
			
			
			<dd>
				<a href="toContractInfo" target="main">Contract Info</a>
			</dd>
			<dd>
				<a href="toCustomerInfo" target="main">Customer Info</a>
			</dd>
			<dd>
				<a href="operatorFrame" target="_top">Operate Contract</a>
			</dd>
		</dl>
	</div>
  </body>
</html>
