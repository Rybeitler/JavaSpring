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
		<h2 class="fs-2 text-light"><c:out value="${category.name}"/></h2>
		<a href="/" class="btn btn-success m-2">Home</a>	
	</div>
	<div class="container">
	<div class="container-fluid m-2 p-2 bg-secondary">
		<div class="m-2">
			<h2 class=" fs-1">Products:</h2>
			<ul>
				<c:forEach var="product" items="${assignedProd}">
					<li><c:out value="${product.name}"/></li>
				</c:forEach>
			</ul>
		</div>
	</div>
		<div class="container-fluid m-2 p-2 bg-secondary">
		<div class="m-2 d-flex justify-content-between">
			<h2 class=" fs-1">Add a Product to this category:</h2>
		</div>
		<div class="container">
		<form:form action="/categories/${category.id}" method="post" modelAttribute="addToCat">
			<div class="form-group m-1 fs-5">
				<select name="productId" id="productId" class="input">
					<c:forEach var="product" items="${availableProd}">
						<option value="${product.id}">${product.name}</option>
					</c:forEach>
				</select>
            </div>
             <input type="submit" class="btn btn-primary m-2"/>
			</form:form>
		</div>
	</div>
	</div>
</body>
</html>