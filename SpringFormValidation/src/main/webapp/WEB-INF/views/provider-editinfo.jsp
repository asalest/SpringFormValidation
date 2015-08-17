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
			 <div class="crearTabla">
				<!-- Default panel contents -->
				<div >
					<h3>
						<strong>Personal Info</strong>
					</h3> 
				</div>
				<form:form modelAttribute="currentProvider" class="form-horizontal" method="post"> 
					<table class="table table-bordered table-hover table-condensed" id="tabla">							
					<tr>
		                <td>Name</td>
		                <td>
							<form:input type="text" class="form-control" path="name" placeholder="${currentProvider.name}" /> 
							<form:errors path="name" element="span" cssClass="error"/>
						</td>
		            </tr>
		            <tr>
		            	<td>Email:</td>
		            	<td>
		            		<form:input type="text" class="form-control" path="email" placeholder="${currentProvider.email}"/>
		            		<form:errors path="email" element="span" cssClass="error"/>
		            	</td>
		            </tr>
		            <tr>
						<th>Place:</th>       
							<td>          
								<form:select class="form-control" path="place">                
									<form:option value="" label="Select Place" />  
									<form:option value="BARCELONA" label="Barcelona" />
									<form:option value="LLEIDA" label="Lleida" />                                  
								</form:select> 
							<form:errors path="place" element="span" cssClass="error"/>    
						</td>
					</tr>
		            <tr>
		                <th>Phone:</th> 
		                <td><form:input path="phone" />
		               <form:errors path="phone" cssClass="error" /></td>
		            </tr>
		            <tr>
		            	<th>Comentario:</th>
					     <td>
					        <form:input type="text" class="form-control" path="comentario" placeholder="${currentProvider.comentario}" />
					       	<form:errors path="comentario" cssClass="error" />
					     </td>
					</tr>
		            <tr>
						<th>User:</th>
						<td>
						  	<form:input type="text" class="form-control" path="user" placeholder="${currentProvider.user}" />
						</td>
						<td>
							<form:errors path="user" cssClass="error" />
						</td>
					</tr>
					<tr>
						<th>Password:</th>
						<td>
						  	<form:input type="password" class="form-control" path="password" />
						</td>
						<td>
							<form:errors path="password" cssClass="error" />
						</td>
					</tr>
				</table>
				
				<input type="submit" value="Save Changes" />
				</form:form>
			</div>
		</div>
	</div>
	 
			
	<p class="home"><a href="/spring"><input type="submit" value="<--Home" /></a></p>
		
	<!-- <div id="peu">
		<p>Ariadne Sales</p>
	</div>-->

</body>
</html>