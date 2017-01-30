<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Customer Registration</title>
</head>
<body>
	<form:form name="submitForm" method="POST" commandName="customerDetailVO">

		<div align="center">
		<h2>${msg}</h2>
		<div style="color: red">${error}</div>
		<div style="color: green">${success}
		<c:if test="${isSucessfull}"> 
		<a href="<%=request.getContextPath() %>/login">Login Here</a>
		</c:if>
		</div>
			<table>
				<tr>
					<td>User Name</td>
					<td><form:input type="text" name="custName"  path="custName" id="custName" />
					<form:errors path="custName"></form:errors></td>
				</tr>
				<tr>
					<td>User Email Id</td>
					<td><form:input type="text" name="customerVO.custEmail"  path="customerVO.custEmail" id="custEmail" />
					<form:errors path="customerVO.custEmail"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input type="password" name="customerVO.custPassword" path="customerVO.custPassword" id="custPassword"/>
					<form:errors path="customerVO.custPassword"/></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><form:input type="password" name="confirmPassword" path="confirmPassword" id="confirmPassword"/>
					<form:errors path="confirmPassword"/></td>
				</tr>
				<tr>
					<td>Telephone No</td>
					<td><form:input type="text" name="customerVO.custTelephone" path="customerVO.custTelephone" id="custTelephone"/>
					<form:errors path="customerVO.custTelephone"/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>
					<form:radiobutton path="custGender" value="Male" />Male 
					<form:radiobutton path="custGender" value="Female" />Female
					<form:radiobutton path="custGender" value="Others" />Others
					<form:errors path="custGender"/>
					</td>
				</tr>
				<tr>
					<td>Partner Name</td>
					<td><form:input type="text" name="custSpouse"  path="custSpouse" id="custSpouse" /></td>
				</tr>
				<tr>
					<td>Address Line 1</td>
					<td><form:input type="text" name="addressVO.address"  path="addressVO.address" id="address" /></td>
				</tr>
				<tr>
					<td>Address Line 2</td>
					<td><form:input type="text" name="addressVO.address2"  path="addressVO.address2" id="address2" /></td>
				</tr>
				<tr>
					<td>City</td>
					<td><form:input type="text" name="addressVO.city"  path="addressVO.city" id="city" /></td>
				</tr>
				<tr>
					<td>District</td>
					<td><form:input type="text" name="addressVO.district"  path="addressVO.district" id="district" /></td>
				</tr>
				<tr>
					<td>State</td>
					<td><form:input type="text" name="addressVO.state"  path="addressVO.state" id="state" /></td>
				</tr>
				<tr>
					<td>Country</td>
					<td><form:input type="text" name="addressVO.country"  path="addressVO.country" id="country" /></td>
				</tr>
				<tr>
					<td>Pin Code</td>
					<td><form:input type="text" name="addressVO.postal_code"  path="addressVO.postal_code" id="pinCode" />
					<form:errors path="addressVO.postal_code"/></td>
				</tr>
				
								
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" />
					
					<input type="reset" value="Reset" /></td>
				</tr>
				
			</table>
			

		</div>
	</form:form>
</body>
</html>