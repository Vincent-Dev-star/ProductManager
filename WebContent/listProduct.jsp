<%@page import="java.util.Iterator"%>
<%@page import="fr.myschool.productmanager.entity.Product"%>
<%@page import="fr.myschool.productmanager.dao.OldProductDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WebProduct</title>

</head>
<body>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<jsp:include page="header.jsp"/>


	<form action="/ProductManager/auth/removeProduct" method="post">

		<label for="id"><b>id</b></label> <input type="text"
			placeholder="Enter id" name="id">
		<button type="submit">RemoveProduct</button>
	</form>
	<div>
		<table>
			<c:forEach items="${listProduct}" var="t">
				<tr>
					<td>name: <c:out value="${t.name}" /></td>
					<td>Description: <c:out value="${t.description}" /></td>
					<td>Price: <c:out value="${t.price}" /></td>
					<td>id: <c:out value="${t.id}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>



</body>

<%@include file="footer.jsp"%>
</html>