<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Project</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between bg-dark bg-opacity-10">
		<h2 class="fs-2 text-light">Create a Project</h2>
		<div>
			<a href="/logout" class="btn btn-danger m-2">Logout</a>	
		</div>
	</div>
	<div class="container">
	<div class="container bg-secondary bg-gradient m-2 p-2">
		<form:form action="/projects/new" method="post" modelAttribute="newProject">
			<div class="form-group m-1 fs-5">
                <form:label class="form-label" path="title">Project Title:</form:label>
                <form:errors class="text-danger" path="title"/>
                <form:input type="text" class="form-control mt-2" path="title"/>
            </div>
            <div class="form-group m-1 fs-5">
                <form:label class="form-label" path="description">Description:</form:label>
                <form:errors class="text-danger" path="description"/>
                <form:textarea class="form-control" rows="3" path="description"/>
            </div>
             <div class="form-group m-1 fs-5">
                <form:label class="form-label" path="dueDate">Due Date:</form:label>
                <form:errors class="text-danger" path="dueDate"/>
                <form:input type="date" class="form-control mt-2" path="dueDate"/>
            </div>
            <input type="submit" class="btn btn-primary m-2 fs-4" value="Create Project">
            <a href="/dashboard" class="btn btn-danger m-2 fs-4">Cancel</a>
		</form:form>
	</div>
	</div>
</body>
</html>