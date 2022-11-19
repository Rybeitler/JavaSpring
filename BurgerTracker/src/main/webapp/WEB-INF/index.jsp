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
	<div class="container">
		<h2 class="m-2 fs-1">Burger Tracker</h2>
		 <table class="table table-striped table-warning table-border-dark">
			<thead>
				<tr>
					<td>Burger Name</td>
					<td>Restaurant Name</td>
					<td>Rating(out of 5)</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="burger" items="${burgers}">
					<tr>
						<td>${burger.name}</td>
						<td>${burger.restaurant}</td>
						<td>${burger.rating}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container bg-secondary bg-gradient">
		<h2 class="m-2 fs-2">Add a Burger:</h2>
		<form:form action="/burger/add" method="post" modelAttribute="newBurger">
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