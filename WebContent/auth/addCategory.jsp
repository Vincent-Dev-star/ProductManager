<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save a Category</title>
<jsp:include page="/header.jsp" />
</head>
<body>
	<form action="/ProductManager/auth/addCategory" method="post">
		<div class="container">

			<label for="name"><b>name</b></label> <input type="text"
				placeholder="Enter name" name="name"> <label
				for="category_id"><b>id</b></label> <input type="text"
				placeholder="Enter id" name="category_id">

			<button type="submit">Save</button>
		</div>
	</form>

	<jsp:include page="/footer.jsp" />


</body>
</html>