<<<<<<< HEAD
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Contract Management - Administrator page</title>
		<link href="css/frame.css" rel="stylesheet" 
			type="text/css" />
	</head>

	<!-- Frame structure:upper, middle (left, right), under-->
	<frameset rows="100,*" frameborder="no" border="0">
		<frame src="Header.jsp"  scrolling="no"/>
		<frameset cols="200,*">
			<frame src="AdminLeft.jsp"  scrolling="no"/>
			<frame src="welcome.jsp"  name="main"  scrolling="auto"/>
		</frameset>
	</frameset>
	<!-- Set prompt message for browser that does not support Frame structure-->
	<noframes>
		<body>
			Your browser does not support frame structure!
		</body>
	</noframes>
</html>
   
=======
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Add Role</title>
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
	</head>

	<body>
		<div class="mtitle">
			Add role
		</div>
		<br />
		
		

		<br />
		<form action="addRole" method="post">
			<table class="update" style="width:700px;">
				<tr height="28">
					<td width="100">Role name:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr height="28">
					<td>Description：</td>
					<td>
						<textarea rows="4" cols="40" name="content" style="width:400px;height:100px;"></textarea>
					</td>
				</tr>
				<tr>
					<td>Configure permission:</td>	
					<td>
						<div>
							Contract Management:<br />
							<input name="check" type="checkbox" value="001" />Draf Contract
							<input name="check" type="checkbox" value="002" />Edit Contract
							<input name="check" type="checkbox" value="003" />Query Contract
							<input name="check" type="checkbox" value="004" />Delete Contract
							<br /><br />
							Process Management:<br />
							<input name="check" type="checkbox" value="005" />Cuntersign
							<input name="check" type="checkbox" value="006" />Approve
							<input name="check" type="checkbox" value="007" />Sign
							<br />
							<input name="check" type="checkbox" value="008" />Assign countersign
							<input name="check" type="checkbox" value="009" />Assign Approval
							<input name="check" type="checkbox" value="010" />Assign Sign
							<br />
							<input name="check" type="checkbox" value="011" />Query Process
							<br /><br />
							User Management:<br />
							<input name="check" type="checkbox" value="012" />Add User
							<input name="check" type="checkbox" value="013" />Edit User
							<input name="check" type="checkbox" value="014" />Query User
							<input name="check" type="checkbox" value="015" />Delete User
							<br /><br />
							Role Management:<br />
							<input name="check" type="checkbox" value="016" />Add Role
							<input name="check" type="checkbox" value="017" />Edit Role
							<input name="check" type="checkbox" value="018" />Query Role
							<input name="check" type="checkbox" value="019" />Delete Role
							<br /><br />
							Function Operation:<br />
							<input name="check" type="checkbox" value="020" />Add Function
							<input name="check" type="checkbox" value="021" />Edit Function
							<input name="check" type="checkbox" value="022" />Query Function
							<input name="check" type="checkbox" value="023" />Delete Function
							<br /><br />
							Authorize:<br />
							<input name="check" type="checkbox" value="024" />Configure permission
							<br /><br />
							Customer Management:<br />
							<input name="check" type="checkbox" value="025" />Add Customer
							<input name="check" type="checkbox" value="026" />Edit Customer
							<input name="check" type="checkbox" value="027" />Query Customer
							<input name="check" type="checkbox" value="028" />Delete Customer
							<br /><br />
							System Log:<br />
							<input name="check" type="checkbox" value="029" />Query Log
							<input name="check" type="checkbox" value="030" />Delete Log
						</div>
					</td>
				</tr>

				<tr height="28">
					<td align="center" colspan="2">
						<input type="submit" value="Submit" class="button"> &nbsp; &nbsp; &nbsp;
						<input type="reset" value="Reset" class="button">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
>>>>>>> origin/LiWenjie
