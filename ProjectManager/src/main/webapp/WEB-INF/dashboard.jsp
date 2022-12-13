
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${user.firstName}"/>'s dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between bg-dark bg-opacity-10">
		<h2 class="fs-2 text-light">Welcome <c:out value="${user.firstName}"/>!</h2>
		<a href="/logout" class="btn btn-danger m-2">Logout</a>	
	</div>
	<div class="container gx-5 p-2 bg-secondary">
		<div class="container">
			<h2 class="fs-2 m-2 text-primary bg-light">Available Projects</h2>
			<table class="table table-striped table-primary">
				<thead>
					<tr>
						<td>Project</td>
						<td>Lead</td>
						<td>Due Date</td>
						<td>Actions</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${projects}">
						<tr>
							<td><a href="/projects/${project.id}">${project.title}</a></td>
							<td>${project.lead.firstName}</td>
							<td><fmt:formatDate value="${project.dueDate}" pattern="MMM dd, YYYY"/></td>
							<td><a href="/projects/join/${project.id}">Join Project</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container">
			<div class="container d-flex justify-content-between">
				<h2 class="fs-2 m-2 text-success bg-light">My Projects</h2>
				<a href="/projects/new" class="btn btn-primary m-2">Add a Project</a>
			</div>
			<table class="table table-striped table-success">
				<thead>
					<tr>
						<td>Project</td>
						<td>Lead</td>
						<td>Due Date</td>
						<td>Actions</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${myProjects}">
						<tr>
							<td><a href="/projects/${project.id}">${project.title}</a></td>
							<td>${project.lead.firstName}</td>
							<td><fmt:formatDate value="${project.dueDate}" pattern="MMM dd, YYYY"/></td>
							<c:choose>
									<c:when test="${project.lead.id==user.id}"><td><a href="/projects/edit/${project.id}">Edit</a></td></c:when>
									<c:otherwise><c:out value="${book.user.name}"/><td><a href="/projects/leave/${project.id}">Leave Project</a></td></c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>