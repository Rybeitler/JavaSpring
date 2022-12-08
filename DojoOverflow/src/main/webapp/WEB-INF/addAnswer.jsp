<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>answer page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between bg-dark bg-opacity-10">
		<h2 class="fs-2 text-light"><c:out value="${question.questionText}"/></h2>
		<a href="/" class="btn btn-success m-2">Back</a>	
	</div>
	<div class="container">
	<div class="container d-flex">
		<c:forEach var="tag" items="${question.tags}">
			<p class="m-2 p-2 bg-success text-light"><c:out value="${tag.subject}"/></p>
		</c:forEach>
	</div>
	<div>
	<div class="container-fluid">
		<table class="table table-striped table-success">
			<thead>
				<tr>
					<td>Answers</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="answer" items="${question.answers}">
					<tr>
						<td>${answer.answerText}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container-fluid">
			<form:form action="/answers/${question.id}" method="post" modelAttribute="newAnswer">
			<div class="form-group m-1 fs-5">
                <form:label class="form-label" path="answerText">Your Answer:</form:label>
                <form:errors class="text-danger" path="answerText"/>
                <form:textarea rows="3" class="form-control mt-2" path="answerText"/>
            </div>
            <input type="submit" class="btn btn-primary m-2 fs-4" value="Answer Question">
		</form:form>
	</div>
	</div>
	</div>
</body>
</html>