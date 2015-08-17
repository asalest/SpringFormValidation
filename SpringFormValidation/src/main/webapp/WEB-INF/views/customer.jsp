<!DOCTYPE html> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form2" uri="http://www.springframework.org/tags/form" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
<head>
<!--  <style type="text/css"> <--%@include file="style.css" %> </style>-->
<style type="text/css"> <%@include file="../styles/style.css" %> </style>
<link rel="stylesheet" href="/resources/themes/master.css" type="text/css" />
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
 rel="stylesheet" type="text/css" />
 
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Save Page</title>


<script
 src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"
 type="text/javascript"></script>
<script
 src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
 type="text/javascript"></script>
<script
 src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/jquery.validate.js"
 type="text/javascript"></script>
<script src="/resources/scripts/mysamplecode.js" type="text/javascript"></script>

<style>
body{
	font-family:helvetica;
	color:#6a7841;
}
</style>

</head>
<body>

	<div id="capcelera">
		<h2>FormValidation <br>
			<small>Create customers</small>
		</h2>
	</div>	
	
	<!--<button class="btn btn-default" id="boton">Modal</button> -->

	<div id="cos">
		<div>
		<div id="personalInfo">
			<h3 class="panel-tittle">
				<strong>Personal Info</strong>
				<a href="<c:url value="customer-editinfo"/>"  class="panel-right btn bnt-default glyphicon glyphicon-edit" ></a>
			</h3> 
		</div>
				
		<table class="table table-bordered">
			<tr>
				<th>Name</th>
				<td>${currentCustomer.name}</td>
			</tr>
			<tr>
				<th>Age</th>
				<td>${currentCustomer.age}</td>
			</tr>
			<tr>
				<th>Birthday</th>
				<td>${currentCustomer.birthday}</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${currentCustomer.email}</td>
			</tr>
			<tr>
				<th>gender</th>
				<td>${currentCustomer.gender}</td>
			</tr>
			<tr>
				<th>Phone</th>
				<td>${currentCustomer.phone}</td>
			</tr>
			<tr>
				<th>User</th>
				<td>${currentCustomer.user}</td>
			</tr>
		</table>
	</div>
		
	</div>
	 
	 	
		<p class="home"><a href="/spring"><input type="submit" value="<--Home" /></a></p>
		
	<!-- <div id="peu">
		<p>Ariadne Sales</p>
	</div>-->

</body>
</html>