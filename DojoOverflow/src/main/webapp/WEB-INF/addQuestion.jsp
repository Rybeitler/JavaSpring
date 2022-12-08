<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Question</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between bg-dark bg-opacity-10">
		<h2 class="fs-2 text-light">Ask a new Question</h2>
		<div>
			<a href="/" class="btn btn-success m-2">Back</a>	
		</div>
	</div>
	<div class="container">
	<div class="container bg-secondary bg-gradient m-2 p-2">
		<form:form action="/questions/new" method="post" modelAttribute="newQuestion">
			<div class="form-group m-1 fs-5">
                <form:label class="form-label" path="questionText">Your Question:</form:label>
                <form:errors class="text-danger" path="questionText"/>
                <form:textarea rows="3" class="form-control mt-2" path="questionText"/>
            </div>
			<div class="form-group m-1 fs-5">
                <label class="form-label">Tags</label>
                <input class="input" name="theTags" id="theTags" />
            </div>

            <input type="submit" class="btn btn-primary m-2 fs-4" value="Ask Question">
		</form:form>
	</div>
	</div>
</body>
</html>