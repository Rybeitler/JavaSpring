<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Omikuji</title>
</head>
<body>
	<div class="container gx-5 bg-info bg-opacity-25">
        <h2 class="m-2 fs-1">Your Omikuji</h2>
        <p class="m-2 fs-3">In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with
        <c:out value="${person}"/> as your roommate, <c:out value="${profession}"/> for a living. The next time
        you see a <c:out value="${thing}"/>, you will have good luck. Also, <c:out value="${nice}"/>.</p>
		<p><a class="text-light fs-3" href="/omikuji">Go Back</a></p>
    </div>
</body>
</html>