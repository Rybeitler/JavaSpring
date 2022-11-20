<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
	<div class="d-flex justify-content-around">
				<h2 class="m-2 fs-2">Expense Details:</h2>	
				<a href="/expenses" class="btn btn-primary m-2">Back to Expenses</a>
	</div>
	<div class="container bg-secondary bg-gradient">
		<div class="d-flex flex-row fs-3">
			<p>Expense Name:    </p>
			<p><c:out value="${expense.name}"/></p>
		</div>
		<div class="d-flex flex-row fs-3">
			<p>Expense Description:</p>
			<p><c:out value="${expense.description}"/></p>
		</div>
		<div class="d-flex flex-row fs-3">
			<p>Vendor:</p>
			<p><c:out value="${expense.vendor}"/></p>
		</div>
		<div class="d-flex flex-row fs-3">
			<p>Amount Spent:</p>
			<p><c:out value="${expense.price}"/></p>
		</div>
	</div>
	</div>
</body>
</html>