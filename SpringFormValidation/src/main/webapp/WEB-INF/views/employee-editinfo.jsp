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
			<small>Employee</small>
		</h2>
	</div>
	
	<div id="menuV">
		<div class="btn-group-vertical" role="group" aria-label="...">
			
			<form action="/spring">
    			<input class="btn btn-default" id="redo"  type="submit" value="Home">
			</form>
			
	
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Customers"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="cust/save">Create</a></li>
	      		<li><a id="submenu" href="cust/custList?page=1">List</a></li>
			    </ul>
			</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Employees"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="emp/save">Create</a></li>
	      		<li><a id="submenu" href="emp/empList?page=1">List</a></li>
			    </ul>
	  		</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Providers"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="prov/save">Create</a></li>
	      		<li><a id="submenu" href="prov/provList?page=1">List</a></li>
	    		</ul>
	  		</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Search"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="search?page=1">Search</a></li>
	    		</ul>
	  		</div>
		</div>
	</div>
	<!--<button class="btn btn-default" id="boton">Modal</button> -->

	<div id="cos">
		<div>
		<div id="personalInfo">
			<h3 class="panel-tittle">
						<strong>Personal Info</strong>
					</h3> 
				</div>
				<form:form modelAttribute="currentEmployee" class="form-horizontal" method="post"> 
					<table class="table table-bordered" id="tabla">
						<tr>
							<th>Name</th>
							<td>
								<form:input type="text" class="form-control" path="name" placeholder="${currentEmployee.name}" /> 
								<form:errors path="name" element="span" cssClass="error"/>
							</td>
						</tr>
						<tr>
							<th>Role:</th>       
							<td>          
								<form:select class="form-control" path="role">                
									<form:option value="" label="Select Role" />  
									<form:option value="CEO" label="ceo" />
									<form:option value="developer" label="developer" />  
                      			    <form:option value="manager" label="Manager" />                                     
								</form:select> 
								<form:errors path="role" element="span" cssClass="error"/>    
							</td>
						</tr>
						<tr>
					        <th>Comentario:</th>
					        <td>
					        	<form:input type="text" class="form-control" path="comentario" placeholder="${currentEmployee.comentario}" />
					        </td>
					        <td>
					        	<form:errors path="comentario" cssClass="error" />
					        </td>
						</tr>
						<tr>
					        <th>User:</th>
					        <td>
					        	<form:input type="text" class="form-control" path="user" placeholder="${currentEmployee.user}" />
					        </td>
					        <td>
					        	<form:errors path="user" cssClass="error" />
					        </td>
						</tr>
						<tr>
					        <th>Password:</th>
					        <td>
					        	<form:input type="password" class="form-control" path="password"/>
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