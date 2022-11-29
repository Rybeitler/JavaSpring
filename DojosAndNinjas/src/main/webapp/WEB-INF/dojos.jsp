<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
	<div class="container">
		<h2 class="m-2 fs-1">All Dojos</h2>
		 <table class="table table-striped table-warning table-border-dark">
			<thead>
				<tr>
					<td>Dojo Name</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dojo" items="${dojos}">
					<tr>
						<td class="fs-2"><a href="/dojos/${dojo.id}">${dojo.name}</a></td>
						<td><a href="/ninjas" class="btn btn-success m-1">Add a Ninja</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container bg-secondary bg-gradient">
		<h2 class="m-2 fs-2">Add a new Dojo:</h2>
		<form:form action="/dojos/new" method="post" modelAttribute="newDojo">
			<div class="form-group m-1">
                <form:label class="form-label" path="name">Dojo Name:</form:label>
                <form:errors class="text-danger" path="name"/>
                <form:input type="text" class="form-control mt-2" path="name"/>
            </div>
            <input type="submit" class="btn btn-primary m-2" value="submit">
		</form:form>
	</div>
	</div>
</body>
</html>