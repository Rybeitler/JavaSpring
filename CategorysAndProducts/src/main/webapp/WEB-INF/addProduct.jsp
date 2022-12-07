<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between bg-dark bg-opacity-10">
		<h2 class="fs-2 text-light">New Product Page</h2>
		<div>
			<a href="/" class="btn btn-success m-2">Home</a>	
		</div>
	</div>
	<div class="container">
	<div class="container bg-secondary bg-gradient m-2 p-2">
		<h2 class="m-2 fs-2">Add a Product:</h2>
		<form:form action="/products/new" method="post" modelAttribute="newProd">
			<div class="form-group m-1 fs-5">
                <form:label class="form-label" path="name">Name:</form:label>
                <form:errors class="text-danger" path="name"/>
                <form:input type="text" class="form-control mt-2" path="name"/>
            </div>
			<div class="form-group m-1 fs-5">
                <form:label class="form-label" path="description">Description:</form:label>
                <form:errors class="text-danger" path="description"/>
                <form:input type="text" class="form-control mt-2" path="description"/>
            </div>
			<div class="form-group m-1 fs-5">
                <form:label class="form-label" path="price">Price:</form:label>
                <form:errors class="text-danger" path="price"/>
                <form:input type="number" step="0.01" class="form-control mt-2" path="price"/>
            </div>
            <input type="submit" class="btn btn-primary m-2 fs-4" value="Add Product">
		</form:form>
	</div>
	</div>
</body>
</html>