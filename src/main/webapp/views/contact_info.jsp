<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PhoneBookApplication</title>
</head>
<body style="background-color:powderblue;">
	<h2 style="color: blue; text-align: center;">
		<u>PhoneBook Application1
	</h2>
	<center>
		<font color="green">${succesMsg}</font>
		<center>
			<font color="red">${failedMsg}</font>

			<form:form action="submit" method="POST" modelAttribute="contact">
				<center>
					<table border="2">
						<tr>
							<form:hidden path="contactId"/>
						</tr>
						<!--<td><input type="hidden" value="contactId" /> -->

						<td>Name</td>
						<td><form:input path="contactName" /></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><form:input path="contactEmail" /></td>
						</tr>
						<tr>
							<td>Phone</td>
							<td><form:input path="phno" /></td>
						</tr>
						</table>

						<tr>
							<td></td>
							<td><center><input type="reset" value="Reset" style="color: Teal; "/><input
								type="submit" value="Submit" style="color: Teal; "/></td></center>
						</tr>
					
			</form:form>


			           <a href="/viewContacts">View All Contacts</a>
</body>
</html>
