<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
</head>
<body>
<script type="text/javascript">

function checkDetails(){
	
	alert('in function');
	//check the regex format for email
	//check the min length for password

	
}

</script>
	<form:form name="submitForm" method="POST" onsubmit="checkDetails()">

		<div align="center">
		<h2>${msg}</h2>
			<table>
				<tr>
					<td>User Email Id</td>
					<td><input type="text" name="custEmail"  id="custEmail" required/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="custPassword"  id="custPassword" required/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
				<tr>
					<td></td>
					<td><a href="<%=request.getContextPath() %>/registerCustomer">Register New User</a></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>

		</div>
	</form:form>
</body>
</html>