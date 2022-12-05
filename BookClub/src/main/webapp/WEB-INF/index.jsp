<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login or Register</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex gx-5">
	<div class="container bg-secondary bg-gradient m-2 p-2">
		<h2 class="m-2 fs-2">Register:</h2>
		<form:form action="/register" method="post" modelAttribute="newUser">
			<div class="form-group m-1 fs-5">
                <form:label class="form-label" path="name">Name:</form:label>
                <form:errors class="text-danger" path="name"/>
                <form:input type="text" class="form-control mt-2" path="name"/>
            </div>
            <div class="form-group m-1 fs-5">
                <form:label class="form-label" path="email">Email:</form:label>
                <form:errors class="text-danger" path="email"/>
                <form:input type="text" class="form-control mt-2" path="email"/>
            </div>
            <div class="form-group m-1 fs-5">
                <form:label class="form-label" path="password">Password:</form:label>
                <form:errors class="text-danger" path="password"/>
                <form:input type="password" class="form-control mt-2" step="0.01" path="password"/>
            </div>
			<div class="form-group m-1 fs-5">
                <form:label class="form-label" path="confirm">Confirm Password:</form:label>
                <form:errors class="text-danger" path="confirm"/>
                <form:input type="password" class="form-control mt-2" path="confirm"/>
            </div>
            <input type="submit" class="btn btn-primary m-2 fs-4" value="Register">
		</form:form>
	</div>
	<div class="container bg-secondary bg-gradient m-2 p-2">
		<h2 class="m-2 fs-2">Login</h2>
		<form:form action="/login" method="post" modelAttribute="newLogin">
			<div class="form-group fs-5 m-1">
                <form:label class="form-label" path="email">Email:</form:label>
                <form:errors class="text-danger" path="email"/>
                <form:input type="text" class="form-control mt-2" path="email"/>
            </div>
            <div class="form-group m-1">
                <form:label class="form-label" path="password">Password:</form:label>
                <form:errors class="text-danger" path="password"/>
                <form:input type="password" class="form-control mt-2" path="password"/>
            </div>
            <input type="submit" class="btn btn-success m-2" value="Login">
		</form:form>
	</div>
	</div>
</body>
</html>