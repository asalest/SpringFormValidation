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

<style type="text/css"> <%@include file="../styles/style.css" %> </style>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Save Page</title>

</head>
<body>
 	<div id="capcelera">
		<h2>FormValidation <br>
			<small>Create Employees</small>
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
	      		<li><a id="submenu" href="../cust/save">Create</a></li>
	      		<li><a id="submenu" href="../cust/custList?page=1">List</a></li>
			    </ul>
			</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      			<fmt:message key="Employees"/>
	      			<span class="caret"></span>
	    		</button>
	    		<ul class="dropdown-menu">
	      		<li><a id="submenu" href="save">Create</a></li>
	      		<li><a id="submenu" href="empList?page=1">List</a></li>
			    </ul>
	  		</div>
	  		<div class="btn-group" role="group">
	    		<button id="redo" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
		<springForm:form method="POST" commandName="employee" action="save.do">
     <div class="crearTabla">
	     <table class="table table-hover">
            <tr>
                 <td><fmt:message key="Name"/></td>
	             <td><springForm:input path="name" /></td>
	             <td><springForm:errors path="name" cssClass="error" /></td>
            </tr>
            <tr>
                <td><fmt:message key="Role"/></td>
                <td>
                	<springForm:select path="role">
                        <springForm:option value="" label="Select Role" />
                        <springForm:option value="ceo" label="CEO" />
                        <springForm:option value="developer" label="Developer" />
                        <springForm:option value="manager" label="Manager" />
                    </springForm:select>
                </td>
                <td><springForm:errors path="role" cssClass="error" /></td>
            </tr>
	            <tr>
	                <td><fmt:message key="Comentario"/></td>
	                <td><springForm:input path="comentario" /></td>
	                <td><springForm:errors path="comentario" cssClass="error" /></td>
	            </tr>
            <!-- USER -->
	            <tr>
	                <td><fmt:message key="User"/></td>
	                <td><springForm:input path="user" /></td>
	                <td><springForm:errors path="user" cssClass="error" /></td>
	            </tr>
	            <tr>
	                <td><fmt:message key="Password"/></td>
	                <td><springForm:input  type="password" path="password" /></td>
	                <td><springForm:errors path="password" cssClass="error" /></td>
	            </tr>
        </table>
	        
	        
	        <input type="submit" value="Save Employee">
	        
	        
	        <p class="home"><a href="/spring"><input type="submit" value="<--Home" /></a></p>
	           
        </div>
        

    </springForm:form>
	</div>
	
	<!-- <div id="peu">
		<p>Ariadne Sales</p>
	</div>-->

</body>
</html>