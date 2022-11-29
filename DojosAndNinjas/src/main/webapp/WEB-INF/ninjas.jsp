<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninjas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
	<div class="container bg-secondary bg-gradient">
		<h2 class="m-2 fs-2">Add a new Ninja:</h2>
		<form:form action="/ninjas/new" method="post" modelAttribute="newNinja">
			<div class="form-group m-1">
                <form:label class="form-label" path="dojo">Dojo:</form:label>
                <form:select  class="form-select" path="dojo">
                	<c:forEach var="dojo" items="${dojos}">
                		<option value="${dojo.id}">${dojo.name}</option>
                	</c:forEach>
                </form:select>
            </div>
			<div class="form-group m-1">
                <form:label class="form-label" path="firstName">First Name:</form:label>
                <form:errors class="text-danger" path="firstName"/>
                <form:input type="text" class="form-control mt-2" path="firstName"/>
            </div>
      		<div class="form-group m-1">
                <form:label class="form-label" path="lastName">Last Name:</form:label>
                <form:errors class="text-danger" path="lastName"/>
                <form:input type="text" class="form-control mt-2" path="lastName"/>
            </div>
           	<div class="form-group m-1">
                <form:label class="form-label" path="age">Age:</form:label>
                <form:errors class="text-danger" path="age"/>
                <form:input type="number" class="form-control mt-2" path="age"/>
            </div>
            <input type="submit" class="btn btn-primary m-2" value="submit">
		</form:form>
	</div>
	</div>
</body>
</html>