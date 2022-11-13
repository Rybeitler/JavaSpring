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
	<div class="container gx-5 bg-dark">
        <h2 class="text-light m-2">Send an Omikuji</h2>
        <form action="/omikuji/create" method="post">
        	<div class="form-group m-1">
        		<label class="form-label text-light">Pick a number from 5-25</label>
        		<input type="number" class="form-control mt-2" name="number" min="5" max="25"/>
        	</div>
            <div class="form-group m-1">
                <label class="form-label text-light">Enter the name of a city:</label>
                <input type="text" class="form-control mt-2" name="city">
            </div>
            <div class="form-group m-1">
                <label class="form-label text-light">Enter the name of a real person:</label>
                <input type="text" class="form-control mt-2" name="person">
            </div>
            <div class="form-group m-1">
                <label class="form-label text-light">Enter a profession or hobby:</label>
                <input type="text" class="form-control mt-2" name="profession" />
            </div>
            <div class="form-group m-1">
                <label class="form-label text-light">Enter the type of a living thing:</label>
                <input type="text" class="form-control mt-2" name="thing">
            </div>
            <div class="form-group m-1">
                <label class="form-label text-light">Say something nice to someone:</label>
                <textarea class="form-control" name="nice" id="nice"  rows="3"></textarea>
            </div>
            <button type="submit" class="btn btn-primary m-2">Submit</button>
        </form>
    </div>
</body>
</html>