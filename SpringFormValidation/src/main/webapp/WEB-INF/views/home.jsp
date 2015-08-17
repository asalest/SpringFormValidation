
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css"> <%@include file="../styles/style.css" %> </style>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style>
body{
	font-family:helvetica;
    background:#e0e6d0;
}
</style>

<title>Insert title here</title>
</head>
<body>
	<div id="capcelera">
		<h2>FormValidation <br>
			<small>First Example with validations (JSP and Maven)</small>
		</h2>
	</div>
	<div>
		<div id="containerHome">
			<div id="home">
				<div class=homeCajas>
					<springForm:form method="POST" commandName="login" action="login">
						<span class="glyphicon glyphicon-user" style="font-size:20px;" ></span>
						<p class="submit"><input type="submit" name="commit" value="Login Customer"></p>
					</springForm:form>
				</div>
				
				  <div class=homeCajas>
					<springForm:form method="POST" commandName="login" action="loginE">
						<span class="glyphicon glyphicon-briefcase" style="font-size:20px;"></span>
						<p class="submit"><input type="submit" name="commit" value="Login Employee"></p>
					</springForm:form>
				</div>
				<div class=homeCajas>
					<springForm:form method="POST" commandName="login" action="loginP">
						<span class="glyphicon glyphicon-copy" style="font-size:20px;"></span>
						<p class="submit"><input type="submit" name="commit" value="Login Provider"></p>
					</springForm:form>
				</div> 
				
			</div>
		</div>
	</div>
	
	 
			
	
	
</html>



