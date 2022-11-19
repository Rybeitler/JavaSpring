<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
	<div class="container bg-secondary bg-gradient">
		<div class="nav d-flex justify-content-around">
			<h2 class="m-2 fs-1">Edit Burger</h2>
			<a href="/burger" class="btn btn-primary m-2">Back to Burgers</a>
		</div>
		<form:form action="/burger/${thisBurger.id}/edit" method="post" modelAttribute="thisBurger">
			<input type="hidden" name="_method" value="put">
			<div class="form-group m-1">
                <form:label class="form-label" path="name">Burger Name:</form:label>
                <form:errors class="text-danger" path="name"/>
                <form:input type="text" class="form-control mt-2" path="name"/>
            </div>
            <div class="form-group m-1">
                <form:label class="form-label" path="restaurant">Restaurant Name:</form:label>
                <form:errors class="text-danger" path="restaurant"/>
                <form:input type="text" class="form-control mt-2" path="restaurant"/>
            </div>
            <div class="form-group m-1">
                <form:label class="form-label" path="rating">Rating(1-5):</form:label>
                <form:errors class="text-danger" path="rating"/>
                <form:input type="number" class="form-control mt-2" path="rating"/>
            </div>
			<div class="form-group m-1">
                <form:label class="form-label" path="notes">Notes:</form:label>
                <form:errors class="text-danger" path="notes"/>
                <form:input type="text" class="form-control mt-2" path="notes"/>
            </div>
            <input type="submit" class="btn btn-primary m-2" value="submit">
		</form:form>
	</div>
	</div>
</body>
</html>