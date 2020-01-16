<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>PhoneBookApplication</title>
<script type="text/javascript">
  function deletePopup() {
	return confirm("Are You Sure To Delete The Contact")
}
</script>

<body style="background-color:powderblue;">
<h2 style="color: blue; text-align: center;">
	<u>All Contacts </u>
</h2>
<center>
	<a href="/"><u>+Add New Contact</u></a><br> <br>
	<table border="1">
	
		<thead>
			<tr>
				<td>S.no</td>
				<td>Name</td>
				<td>Email</td>
				<td>Phno</td>
				<td>Action</td>
			</tr>
		</thead>
		<c:forEach items="${listContacts}" var="cnt" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${cnt.contactName}</td>
				<td>${cnt.contactEmail}</td>
				<td>${cnt.phno}</td>
				<td><a href= "editContact?contId=${cnt.contactId}">Edit</a>
				    <a href="deleteContact?contId=${cnt.contactId}"onclick="return deletePopup()" >Delete</a>
				</td>
		</c:forEach>
		</tr>
	</table>
</body>