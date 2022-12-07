<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between bg-dark bg-opacity-10">
		<h2 class="fs-2 text-light">Home Page</h2>	
	</div>
	<div class="container">
	<div class="container-fluid m-2 p-2 bg-secondary">
		<div class="m-2 d-flex justify-content-between">
			<h2 class=" fs-1">Categories</h2>
			<a href="/categories/new" class="btn btn-success m-2">Add a Category</a>
		</div>
		<div class="container">
			<ul class="fs-3">
			<c:forEach var="category" items="${categories}">
				<li><a href="/categories/${category.id}"><c:out value="${category.name}"/></a></li>
			</c:forEach>
			</ul>
		</div>
	</div>
		<div class="container-fluid m-2 p-2 bg-secondary">
		<div class="m-2 d-flex justify-content-between">
			<h2 class=" fs-1">Products</h2>
			<a href="/products/new" class="btn btn-success m-2">Add a Product</a>
		</div>
		<div class="container">
			<ul class="fs-3">
			<c:forEach var="product" items="${products}">
				<li><a href="/products/${product.id}"><c:out value="${product.name}"/></a></li>
			</c:forEach>
			</ul>
		</div>
	</div>
	</div>
</body>
</html>