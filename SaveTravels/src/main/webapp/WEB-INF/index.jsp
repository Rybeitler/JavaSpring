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
	<div class="container">
		<h2 class="m-2 fs-1">Save Travels</h2>
		 <table class="table table-striped table-warning table-border-dark">
			<thead>
				<tr>
					<td>Expense</td>
					<td>Vendor</td>
					<td>Amount</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
						<td><a href="/expenses/${expense.id}">${expense.name}</a></td>
						<td>${expense.vendor}</td>
						<td>$${expense.price}</td>
						<td><a href="/expenses/edit/${expense.id}" class="btn btn-warning m-1">Edit</a><a href="/expenses/delete/${expense.id}" class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container bg-secondary bg-gradient">
		<h2 class="m-2 fs-2">Add an Expense:</h2>
		<form:form action="/expenses/new" method="post" modelAttribute="newExpense">
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
                <form:input type="number" class="form-control mt-2" step="0.01" path="price"/>
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