<%@page import="fr.myschool.productmanager.dao.OldProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShowProduct</title>
<style>
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	max-width: 300px;
	margin: auto;
	text-align: center;
	font-family: arial;
}

.price {
	color: grey;
	font-size: 22px;
}

.card button {
	border: none;
	outline: 0;
	padding: 12px;
	color: white;
	background-color: #000;
	text-align: center;
	cursor: pointer;
	width: 100%;
	font-size: 18px;
}

.card button:hover {
	opacity: 0.7;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp" />

	<h2 style="text-align: center">Product:</h2>

	<div class="card">
		<h1>Name: ${name}</h1>

		<p class="price">Price: ${price}</p>
		<p>Description: ${description}</p>
		<p>Category: ${category }</p>

		<form method="get" action="listProduct">
			<button type="submit">Continue</button>
		</form>

	</div>

</body>
</html>
