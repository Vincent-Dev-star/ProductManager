<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="topnav">


		<c:if test="${empty username}">
			<a class="active" href="/ProductManager/login">Login</a>
		</c:if>

		<c:if test="${!empty username}">
			<a class="active" href="/ProductManager/logout">Logout</a>
		</c:if>
		<a href="/ProductManager/listProduct">ListProduct</a> <a
			href="/ProductManager/auth/addProduct">AddProduct</a> <a
			href="/ProductManager/auth/addCategory">AddCategory</a>
	</div>

</body>
</html>