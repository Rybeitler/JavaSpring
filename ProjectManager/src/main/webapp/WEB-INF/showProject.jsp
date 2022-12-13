<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Project</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between bg-dark bg-opacity-10">
		<h2 class="fs-2 text-light">Project Details</h2>
		<div>
			<a href="/dashboard" class="btn btn-warning m-2 fs-4">Back to Dashboard</a>
			<a href="/logout" class="btn btn-danger m-2">Logout</a>	
		</div>
	</div>
	<div class="container">
	<div class="container bg-secondary bg-gradient m-2 p-2">
		<table class="table">
			<tr>
				<td>Project:</td>
				<td><c:out value="${project.title}"/></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><c:out value="${project.description}"/></td>
			</tr>
			<tr>
				<td>Due Date:</td>
				<td><c:out value="${project.dueDate}"/></td>
			</tr>
		</table>
		<a href="/projects/${project.id}/tasks" class="btn btn-primary m-2">See Tasks</a>
		<c:if test="${project.lead.id.equals(user.id)}">
			<a href="/projects/${project.id}/delete" class="btn btn-danger m-2">Delete</a>
		</c:if>
	</div>
	</div>
</body>
</html>