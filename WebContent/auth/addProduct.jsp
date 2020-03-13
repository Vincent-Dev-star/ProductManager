<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save a Product</title>
<jsp:include page="/header.jsp" />
</head>
<body>
	<form action="/ProductManager/auth/addProduct" method="post">
		<div class="container">
			<label for="id"><b>id</b></label> <input type="text"
				placeholder="Enter id" name="id"> <label for="name"><b>name</b></label>
			<input type="text" placeholder="Enter name" name="name"> <label
				for="description"><b>description</b></label> <input type="text"
				placeholder="Enter description" name="description"> <label
				for="price"><b>price</b></label> <input type="text"
				placeholder="Enter price" name="price"> <label
				for="category_id"><b>id category</b></label> <input type="text"
				placeholder="Enter category id" name="category_id">

			<button type="submit">Save</button>
		</div>

		<p>category: ${category}</p>
		<p>id: ${category_id}</p>
	</form>





	<jsp:include page="/footer.jsp" />


</body>
</html>