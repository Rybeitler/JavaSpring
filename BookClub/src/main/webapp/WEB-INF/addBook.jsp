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
		<h2 class="fs-2 text-light">Welcome <c:out value="${user.name}"/>!</h2>
		<div>
			<a href="/allBooks" class="btn btn-success">Back to Library</a>
			<a href="/logout" class="btn btn-danger m-2">Logout</a>	
		</div>
	</div>
	<div class="container">
	<div class="container bg-secondary bg-gradient m-2 p-2">
		<h2 class="m-2 fs-2">Add a Book:</h2>
		<form:form action="/books/new" method="post" modelAttribute="newBook">
			<div class="form-row">
				<form:errors path="user"/>
				<form:input type="hidden" path="user" value="${user.id}"/>
			</div>
			<div class="form-group m-1 fs-5">
                <form:label class="form-label" path="title">Title:</form:label>
                <form:errors class="text-danger" path="title"/>
                <form:input type="text" class="form-control mt-2" path="title"/>
            </div>
            <div class="form-group m-1 fs-5">
                <form:label class="form-label" path="author">Author:</form:label>
                <form:errors class="text-danger" path="author"/>
                <form:input type="text" class="form-control mt-2" path="author"/>
            </div>
            <div class="form-group m-1 fs-5">
                <form:label class="form-label" path="thoughts">My Thoughts:</form:label>
                <form:errors class="text-danger" path="thoughts"/>
                <form:textarea class="form-control" rows="3" path="thoughts"/>
            </div>
            <input type="submit" class="btn btn-primary m-2 fs-4" value="Add Book">
		</form:form>
	</div>
	</div>
</body>
</html>