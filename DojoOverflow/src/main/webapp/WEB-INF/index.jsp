<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between bg-dark bg-opacity-10">
		<h2 class="fs-2 text-light">All Questions</h2>	
	</div>
	<div class="container">
		<table class="table table-striped table-success">
			<thead>
				<tr>
					<td>Question</td>
					<td>Tags</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="question" items="${questions}">
					<tr>
						<td><a href="/answers/${question.id}">${question.questionText}</a></td>
						<td>
							<c:forEach var="tag" items="${question.tags}">
								${tag.subject}
								<c:if test = "${question.tags.indexOf(tag)<question.tags.size()-1}">, </c:if>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/questions/new" class="btn btn-primary m-2">Ask a Question</a>
	</div>
</body>
</html>