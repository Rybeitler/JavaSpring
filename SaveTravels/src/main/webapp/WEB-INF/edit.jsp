<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
	<div class="container bg-secondary bg-gradient">
		<div class="nav d-flex justify-content-around">
			<h2 class="m-2 fs-1">Edit Expense</h2>
			<a href="/expenses" class="btn btn-primary m-2">Back to Expenses</a>
		</div>
		<form:form action="/expenses/edit/${expense.id}" method="post" modelAttribute="expense">
			<input type="hidden" name="_method" value="put">
			<div class="form-group m-1">
                <form:label class="form-label" path="name">Expense Name:</form:label>
                <form:errors class="text-danger" path="name"/>
                <form:input type="text" class="form-control mt-2" path="name"/>
            </div>
            <div class="form-group m-1">
                <form:label class="form-label" path="vendor">Vendor:</form:label>
                <form:errors class="text-danger" path="vendor"/>
                <form:input type="text" class="form-control mt-2" path="vendor"/>
            </div>
            <div class="form-group m-1">
                <form:label class="form-label" path="price">Amount:</form:label>
                <form:errors class="text-danger" path="price"/>
                <form:input type="number" class="form-control mt-2" path="price" step="0.01"/>
            </div>
			<div class="form-group m-1">
                <form:label class="form-label" path="description">Description:</form:label>
                <form:errors class="text-danger" path="description"/>
                <form:input type="text" class="form-control mt-2" path="description"/>
            </div>
            <input type="submit" class="btn btn-primary m-2" value="submit">
		</form:form>
	</div>
	</div>
</body>
</html>