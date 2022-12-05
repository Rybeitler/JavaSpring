<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${user.name}"/>'s dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between bg-dark bg-opacity-10">
		<h2 class="fs-2 text-light">Welcome <c:out value="${user.name}"/>!</h2>
		<a href="/logout" class="btn btn-danger m-2">Logout</a>	
	</div>
	<div class="container">
	<div class="container-fluid m-2 p-2 bg-secondary">
		<div class="d-flex justify-content-between">
			<h2 class="m-2 fs-1">Book Library</h2>
			<a href="/books/new" class="btn btn-success m-2">Add a Book</a>
		</div>
		 <table class="table table-striped table-warning table-border-dark">
			<thead>
				<tr>
					<td>Id</td>
					<td>Title</td>
					<td>Author Name</td>
					<td>Posted By</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td>${book.id}</td>
						<td><a href="/books/${book.id}">${book.title}</a></td>
						<td>${book.author}</td>
						<td>${book.user.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</body>
</html>