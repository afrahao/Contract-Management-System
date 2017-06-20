<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.model.User,com.model.Contract"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Assign operator</title>
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
		<script type="text/javascript">
			function moveOption(s1,s2){
				// Cteate cache array to store value and text
				var arrSelValue = new Array();  
				var arrSelText = new Array();  
				// This array stores the selected options, corresponding to value
				var arrValueTextRelation = new Array();  
				var index = 0;// Assist to establish the cache array
				  
				// Store all data in the source list to the cache, and establish the corresponding relationship of value and selected option
			   for ( var i = 0; i < s1.options.length; i++) {  
					if (s1.options[i].selected) {  
						arrSelValue[index] = s1.options[i].value;  
						arrSelText[index] = s1.options[i].text;  
						// Cteate the corresponding relationship of value and selected option
						arrValueTextRelation[arrSelValue[index]] = s1.options[i];  
						index++;  
					}  
				}  
		  
				// Increase cache data to purpose list, and delete the corresponding item in source list
				for ( var i = 0; i < arrSelText.length; i++) {  
					var oOption = document.createElement("option");  
					oOption.text = arrSelText[i];  
					oOption.value = arrSelValue[i];  
					s2.add(oOption);
					s2.options[i].selected=true;  
					// Delete the corresponding item in source list
					s1.removeChild(arrValueTextRelation[arrSelValue[i]]);  
				} 
			}
			
			// Judgment whether user has assigned operator, if does not assign, giving prompt message; Or submit form to assign operator
			function check(){
				// Cteate cache array to store assigned operator
      		   	var assignedOperator; 
				assignedOperator = document.assignOperForm.hqht;

				// If there is no assigned operator, giving a prompt message
				if((assignedOperator.length) < 1){
					alert("Please choose a user!");
					return false;
				} 
			}
		</script>
	</head>

	<body>
		<div class="mtitle">
			Delete User
		</div>
		<%
			List<User> userList = (List<User>)request.getAttribute("userList");
        %>
		<br /><br />
		<form name="deleteUserForm" action="deleteUser" method="post">
			<table border="0" width="200" class="update"> 
				<tr>
					<td width="45%"> 
						 Users list: 
						<select style="WIDTH:100%" multiple name="userList" size="12">
						    <%  
						    	for (User user : userList) {
			       	 		%> 
							<option value="<%=user.getId()%>"><%=user.getName()%></option> 
							<%} %>
						</select> 
					</td> 
					<td width="10%" align="center"> 
						<input type="button" value="&gt&gt" 
					onclick="moveOption(document.deleteUserForm.userList, document.deleteUserForm.choosenUser)">
						<br/> <br/> 
						<input type="button" value="&lt&lt" 
					onclick="moveOption(document.deleteUserForm.choosenUser, document.deleteUserForm.userList)"> 
					</td> 
					<td width="45%"> 
						Choosen user:
						<select style="WIDTH:100%" multiple name="choosenUser" size="12"> 
						</select> 
					</td> 
				</tr> 				
			</table> 
			
			<table width="400" class="update"> 
				<tr>
					<td colspan="2" style="text-align:center;">
				<input type="submit" value="Submit" class="button" onclick="return check()"> &nbsp; &nbsp; &nbsp; 
				<input type="reset" value="Reset" class="button">
				</td>
				</tr>
			</table>
			<br/>
		</form> 
	</body>
</html>
