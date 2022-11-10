<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruity Loops]</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container m-2 p-2 gx-5">
		<h1 class="m-1 ts-1 text-danger text-opacity-25">Fruit Store</h1>
		<div class="">
			<table class="border border-5 border-danger table table-danger table-striped">
				<c:forEach var="fruit" items="${fruits}">
					<tr>
						<td><c:out value="${fruit.name}"/></td>
						<td><c:out value="${fruit.price}"/></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>