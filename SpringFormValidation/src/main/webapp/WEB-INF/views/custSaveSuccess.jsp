<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<%@ page session="false"  import="com.journaldev.spring.form.controllers.CustomerController"
						 import="com.journaldev.spring.form.model.Customer"
						 import="java.util.List"%>
<html>
<head>
<!--  <style type="text/css"> <--%@include file="style.css" %> </style>-->
<style type="text/css"> <%@include file="../styles/style.css" %> </style>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


    <title>Customer Saved Successfully</title>
    
</head>
<body>
	<div id="capcelera">
		<h2>FormValidation <br>
			<small>Create customers</small>
		</h2>
	</div>
	
	<div id="menuV">
		<div class="btn-group-vertical" role="group" aria-label="...">
			
			<form action="../">
    			<input class="btn btn-default" id="redo"  type="submit" value="Home">
			</form>
			
	
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Customers"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="save">Create</a></li>
	      		<li><a id="submenu" href="custList?page=1">List</a></li>
			    </ul>
			</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Employees"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="../emp/save">Create</a></li>
	      		<li><a id="submenu" href="../emp/empList?page=1">List</a></li>
			    </ul>
	  		</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button"  class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Providers"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="../prov/save">Create</a></li>
	      		<li><a id="submenu" href="../prov/provList?page=1">List</a></li>
	    		</ul>
	  		</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Search"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="../search?page=1">Search Customers</a></li>
	    		</ul>
	  		</div>
		</div>
	</div>
	<!--<button class="btn btn-default" id="boton">Modal</button> -->

	
	<div id="cos">
		<!-- <h3>
	    	Customer Saved Successfully.
		</h3>
	
		<table class="table">
			<tr id="color">
				<th><fmt:message key="Name"/></th>
			 	<th><fmt:message key="Email"/></th>
			 	<th><fmt:message key="Age"/></th>
			 	<th><fmt:message key="Gender"/></th>
			 	<th><fmt:message key="Birthday"/></th>
			 	<th><fmt:message key="Phone"/></th>
			 	<th><fmt:message key="User"/></th>
			 	<th><fmt:message key="Password"/></th>
			</tr>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.age}</td>
					<td>${customer.gender}</td>
					<td><fmt:formatDate value="${customer.birthday}" type="date" /></td>
					<td>${customer.phone}</td>
					<td>${customer.user}</td>
					<td>${customer.password}</td>
				</tr>
			</c:forEach>
		</table>
	 
		<h3 align="center">
		    Datos guardados en la Base de datos
		</h3>
		<table class="table table-bordered table-hover table-condensed" id="tabla">
			<tr>
				<th><fmt:message key="Name"/></th>
			 	<th><fmt:message key="Email"/></th>
			 	<th><fmt:message key="Age"/></th>
			 	<th><fmt:message key="Gender"/></th>
			 	<th><fmt:message key="Birthday"/></th>
			 	<th><fmt:message key="Phone"/></th>
			 	<th><fmt:message key="User"/></th>
			 	<th><fmt:message key="Password"/></th>
			</tr>
			
			<c:forEach items="${customerDB}" var="customerdb">
				<tr>
					<td>${customerdb.name}</td>
				  	<td>${customerdb.email}</td>
				  	<td>${customerdb.age}</td>
				  	<td>${customerdb.gender}</td>
				  	<td><fmt:formatDate value="${customerdb.birthday}" type="date" /></td>
				 	<td>${customerdb.phone}</td>
				  	<td>${customerdb.user}</td>
				  	<td>${customerdb.password}</td>
				</tr>
			</c:forEach>
		</table> -->
		
		<h3>Customer ${customer.name} saved correctly </h3>
		
		<p><a href="custList?page=1">List--></a></p>
	
	</div>
	
	<!-- <div id="peu">
		<p>Ariadne Sales</p>
	</div>-->
</body>
</html>