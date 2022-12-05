<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between bg-dark bg-opacity-10">
		<h2 class="m-2 fs-2 text-light"><c:out value="${book.title}"/></h2>
		<div>
			<a href="/allBooks" class="btn btn-success">Back to Library</a>
			<a href="/logout" class="btn btn-danger m-2">Logout</a>	
		</div>
	</div>
	<div class="container">
	<div class="container bg-secondary bg-gradient m-2 p-2">
		<h2 class="m-2 fs-2">
			<c:choose>
				<c:when test="${book.user.id==user.id}">You</c:when>
				<c:otherwise><c:out value="${book.user.name}"/></c:otherwise>
			</c:choose>
			 read <span class="text-danger"><c:out value="${book.title}"/></span> by <span class="text-primary"><c:out value="${book.author}"/></span>.
		</h2>
		<h2 class="m-2 fs-3">Here are
		<c:choose>
				<c:when test="${book.user.id==user.id}">Your</c:when>
				<c:otherwise><c:out value="${book.user.name}"/>'s</c:otherwise>
		</c:choose>
		 thoughts:
		</h2>
		<h2 class="bg-light fs-4 p-2 m-3"><c:out value="${book.thoughts}"/></h2>
		<div class="d-flex justify-content-center">
			<c:if test="${book.user.id==user.id}">
				<a href="/books/${book.id}/edit" class="btn btn-warning m-2">Edit</a>
				<a href="/books/${book.id}/delete" class="btn btn-danger m-2">Delete</a>
			</c:if>
		</div>
	</div>
	</div>
</body>
</html>