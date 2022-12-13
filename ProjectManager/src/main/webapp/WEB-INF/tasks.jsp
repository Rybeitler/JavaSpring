<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tasks</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between bg-dark bg-opacity-10">
		<h2 class="fs-2 text-light">Project: <c:out value="${project.title}"/></h2>
		<div>
			<a href="/dashboard" class="btn btn-warning m-2 fs-4">Back to Dashboard</a>
			<a href="/logout" class="btn btn-danger m-2">Logout</a>	
		</div>
	</div>
	<div class="container">
	<div class="container bg-secondary bg-gradient m-2 p-2">
		<h2 class="text-light fs-4 m-1">Project Lead: <c:out value="${project.lead.firstName}"/></h2>
		<form:form action="/projects/${project.id}/tasks" method="post" modelAttribute="newTask">
            <div class="form-group m-1 fs-5">
                <form:label class="form-label" path="text">Add a New Task:</form:label>
                <form:errors class="text-danger" path="text"/>
                <form:textarea class="form-control" rows="3" path="text"/>
            </div>
            <input type="submit" class="btn btn-primary m-2 fs-4" value="Submit">
		</form:form>
	</div>
	<div class="container bg-secondary m-2 p-2">
		<h2 class="text-light fs-4 m-1">Tasks:</h2>
		<ul class="text-light">
			<c:forEach var="task" items="${project.tasks}">
				<li>Added By <c:out value="${task.user.firstName}"/> at <fmt:formatDate value="${task.createdAt}" pattern="h:mm a MMMM dd"/></li>
				<li><c:out value="${task.text}"/></li>
			</c:forEach>
		</ul>
	</div>
	</div>
</body>
</html>